package Day37;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSExecutor_ZoomInOut{
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        Thread.sleep(1000);
        driver.manage().window().minimize();
        Thread.sleep(1000);
        driver.manage().window().maximize();


        JavascriptExecutor js = (JavascriptExecutor) driver;

        Thread.sleep(1000);
        js.executeScript("document.body.style.zoom='50%'"); //set zoom level 50%
        Thread.sleep(1000);
        js.executeScript("document.body.style.zoom='100%'");

    }
}
