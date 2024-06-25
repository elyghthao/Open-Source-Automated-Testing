import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Test_ColorBox {
//    3) https://testautomationpractice.blogspot.com/
//    colors multi select box
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://testautomationpractice.blogspot.com/");

        Select colors = new Select(driver.findElement(By.xpath("//select[@id='colors']")));
        List<WebElement> options = colors.getOptions();
        options.forEach((n)-> System.out.println(n.getText()));

        colors.selectByVisibleText("White");
    }
}
