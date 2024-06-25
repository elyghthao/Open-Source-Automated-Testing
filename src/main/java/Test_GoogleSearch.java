import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Test_GoogleSearch {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//textarea")).sendKeys("elygh thao");
        Thread.sleep(2000);
        WebElement parent = driver.findElement(By.xpath("//ul[@role='listbox']"));

        // need to use .// to look under just the parent
//        List<WebElement> options = parent.findElements(By.xpath(".//li"));

        List<WebElement> options = driver.findElements(By.xpath("//ul[@role='listbox']//li"));//not using the parent
        System.out.println("size: " + options.size());
        options.forEach((n)-> System.out.println(n) );
        options.get(0).click();
    }
}
