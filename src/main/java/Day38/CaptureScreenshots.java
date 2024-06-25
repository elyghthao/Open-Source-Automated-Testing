package Day38;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class CaptureScreenshots {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com/");

        //1) full page screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        File targetFile = new File("screenshots\\fullpage.png");
        FileHandler.copy(sourceFile,targetFile);


        //2) Capture the screenshot of specific section
        WebElement featuredProducts = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']//div[@class='item-grid']"));
        File src = featuredProducts.getScreenshotAs(OutputType.FILE);
        File trgt = new File("screenshots\\onlyWebElement.png");
        FileHandler.copy(src,trgt);




    }
}
