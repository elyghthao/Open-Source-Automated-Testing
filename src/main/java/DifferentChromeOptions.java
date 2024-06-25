import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DifferentChromeOptions {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        // headless mode of execution
        options.addArguments("--headless=new");
        //accepts SSL certificates (Websites that are deemed dangerous or that the connections is not private)
        options.setAcceptInsecureCerts(true);
        //removes "Chrome is being controlled by automated test software"
        options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
        //run tests in incognito mode
        options.addArguments("--incognito");//run tests in incognito mode

        WebDriver driver= new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/");


        String title = driver.getTitle();
        System.out.println((title.equals("Your Store") ? "Test Passed" : "Test Failed"));


        driver.quit();
    }
}
