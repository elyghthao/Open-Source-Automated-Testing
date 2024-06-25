import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.function.Function;

public class SleepStatements {

    public static void main(String[]args) throws InterruptedException, MalformedURLException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


        //basic wait for an amount of seconds, write multiple times
//        Thread.sleep(2000);

        //*********************USE THIS ONE
        //implicit wait (does a wait for each statement or error in the script for a maximum amount of time)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //explicit wait (works based on a condition)
//        WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10));
//        WebElement loginUsername = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Username']")));

        //fluent wait
//        Wait<WebDriver> myWait = new FluentWait<WebDriver>(driver)
//                .withTimeout(Duration.ofSeconds(30L))
//                .pollingEvery(Duration.ofSeconds(5L))
//                .ignoring(NoSuchElementException.class);
//        WebElement loginUsername = myWait.until(webDriver -> driver.findElement((By.xpath("//*[@placeholder='Username']"))));


        WebElement loginUsername = driver.findElement(By.xpath("//*[@placeholder='Username']"));
        System.out.println("login: " + loginUsername);
        loginUsername.sendKeys("admin");


        driver.navigate().refresh();
        driver.navigate().to(new URL("https://google.com"));//navigate().to(url)   same as driver.get
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();

    }


}
