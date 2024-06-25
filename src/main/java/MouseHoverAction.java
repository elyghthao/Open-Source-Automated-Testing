import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseHoverAction {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://demo.nopcommerce.com");
        WebElement computers = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']"));
        WebElement desktops =  driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Desktops ']"));

        Actions act = new Actions(driver);


        //.build().perform()    is mandatory for each method from the Action Class
        //moveToElement() -> mouse hover
        //click() -> clicks what the mouse is currently at
        act.moveToElement(computers).moveToElement(desktops).click().build().perform();





    }
}
