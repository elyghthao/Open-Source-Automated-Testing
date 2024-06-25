package Day31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Frame {
    public static void main(String[]args){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://ui.vision/demo/webtest/frames/");

        //frames need to deliberately switched to, in order for webdriver to interact with its elements
        WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Welcome");


        //the driver needs to get put into the default/original window
        driver.switchTo().defaultContent();


        WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("This is Frame 2");

    }
}
