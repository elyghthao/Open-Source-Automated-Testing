package Day35;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DoubleClickAction {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='iframeResult']")));
        WebElement copyButton = driver.findElement(By.xpath("//button[text()='Copy Text']"));
        Actions act = new Actions(driver);
        act.doubleClick(copyButton).build().perform();
    }
}
