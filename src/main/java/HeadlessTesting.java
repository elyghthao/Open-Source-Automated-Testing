import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class HeadlessTesting {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");//setting for headless mode of execution

        WebDriver driver= new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/");


        String title = driver.getTitle();
        if(title.equals("Your Store")){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }

        driver.quit();
    }
}
