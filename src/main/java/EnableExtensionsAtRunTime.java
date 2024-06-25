import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class EnableExtensionsAtRunTime {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();

        //adding extensions significantly increases the amount of time it takes the code to start
        options.addExtensions(new File ("C:\\Automation\\CRX Files\\SelectorsHub.crx"));
        options.addExtensions(new File ("C:\\Automation\\CRX Files\\Adblock.crx"));
//        options.addArguments("--headless=new");


        WebDriver driver = new ChromeDriver(options);
        driver.get("https://text-compare.com"); //the driver defaults to this page, not the extension popup


        //this gets rid of the popup tab and resets everything to default window
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
        driver.close();
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
    }
}
