package Day28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class ClosingSpecificWindow {

    public static void main(String[]args){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //driver will still be focused on the parent window, despite being in another site
        driver.findElement(By.xpath("//a[@href='http://www.orangehrm.com']")).click();

        Set<String> windowIDs = driver.getWindowHandles();//stores the window id's into this set

        for(String winID: windowIDs){
            String title = driver.switchTo().window(winID).getTitle();
            if(title.equals("Human Resources Management Software | OrangeHRM")){
                driver.close();
            }
        }
    }
}
