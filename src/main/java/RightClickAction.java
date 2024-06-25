import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class RightClickAction {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

        WebElement rightClickButton = driver.findElement(By.xpath("//span[text()='right click me']"));

        Actions act = new Actions(driver);

        act.moveToElement(rightClickButton).build().perform();

        Thread.sleep(1000);

        //right click button
        act.contextClick().build().perform();

        WebElement copyButton = driver.findElement(By.xpath("//span[text()='Copy']/ancestor::li"));
        act.click(copyButton).build().perform();
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//a[.='jQuery Context Menu Demo Gallery']")).click();


    }
}
