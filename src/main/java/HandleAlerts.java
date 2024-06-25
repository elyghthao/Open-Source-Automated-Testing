import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleAlerts {

    public static void main(String[]args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1) normal alert with OK Button
//        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//        System.out.println(driver.switchTo().alert().getText());
//        driver.switchTo().alert().accept();


        //2) alert with input
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("CHUPACABRACHUPACABRA");
        driver.switchTo().alert().accept();

//        driver.switchTo().alert().accept()   // close alert box using ok button
//        driver.switchTo().alert().dismiss()  // close alert box using cancel button
//        driver.switchTo().alert().getText() // capture text value from alert
//        driver.switchTo().alert().sendKeys()  // pass the text into inputbox inside the alert

    }
}
