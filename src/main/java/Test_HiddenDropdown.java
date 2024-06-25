import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Test_HiddenDropdown {
//    2) Hidden dropdown
//    Login to OrangeHRM--> pim--> employee status
    public static void main(String[]args){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[2]")).click();


        //open div
        driver.findElement(By.xpath("(//i[contains(@class,'oxd-icon bi-caret-down-fill')])[2]")).click();
        List<WebElement> options = driver.findElements(By.xpath("//div[@role='option']//span"));

        options.forEach( (n) ->
                System.out.println(n.getText())
        );

        System.out.println("options size: " + options.size());
        options.get(5).click();
    }
}
