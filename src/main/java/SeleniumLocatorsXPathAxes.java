import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLocatorsXPathAxes {
    public static void main(String []args){
        System.out.println("HI");

        WebDriver driver = new ChromeDriver();

        driver.get("https://magento.softwaretestingboard.com/");

        WebElement img1 = driver.findElement(By.xpath("//input[@id=\"search\"]"));
//        WebElement img1 = driver.findElement(By.id("search"));
        img1.sendKeys("Shirt");
        System.out.println(img1);

    }
}
//*[@id="search"]