import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo1 {
    public static void main(String[]args){

        WebDriver driver = new ChromeDriver();

        //open app
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();


        //search box
        driver.findElement(By.id("search")).sendKeys("T-shirts");

        //search button
        driver.findElement(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")).click();

        //link text
//        driver.findElement(By.linkText("Zoe Tank")).click();
        driver.findElement(By.partialLinkText("Zoe")).click();//partial link text

    }



}
