import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocatorsDemo2 {

    public static void main(String[]args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://magento.softwaretestingboard.com/");
//        driver.manage().window().maximize();

        //search box
        driver.findElement(By.id("search")).sendKeys("T-shirts");

        //search button
        driver.findElement(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")).click();

        //find list of products listed

        System.out.println("hi");
        Thread.sleep(2000);
        List<WebElement> items = driver.findElements(By.className("product-item-info"));
//        driver.findElement(By.className("product-item-info")).click();
        System.out.println("number of products: " + items.size());

        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("number of images: " + images.size());

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("number of links: " + links.size());
    }
}
