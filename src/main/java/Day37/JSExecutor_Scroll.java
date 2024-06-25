package Day37;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JSExecutor_Scroll {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://testautomationpractice.blogspot.com/");


        WebElement inputBox = driver.findElement(By.xpath("//input[@id='name']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //1) Scroll down page by pixel number
        js.executeScript("window.scrollBy(0,3000)","");
        System.out.println(js.executeScript("return window.pageYOffset;"));

    }
}
