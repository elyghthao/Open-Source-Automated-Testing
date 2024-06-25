import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DatePickerDemo2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://testautomationpractice.blogspot.com/");


        String year="2021";
        String month="June";
        String day="15";
        //Method1 : send keys in textbox

        //Method2 : use dropdown feature
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@frameborder='0']")));
        WebElement element = driver.findElement(By.xpath("//span[@class='icon_calendar']"));

        //scrolls web element into view
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();

        //get month
        while(true){
            driver.findElement(By.xpath("//a[@title='Next']")).click();
            if(driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().equals(month)){
                break;
            }
        }
        //get year
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
        dropdown.selectByVisibleText(year);
        //get day
        List<WebElement> dates = driver.findElements(By.xpath("//tbody//a"));
//        System.out.println("dates.size: " + dates.size());
        dates.forEach((n)->{
            if(n.getText().equals(day)) {
                n.click();
            }
        });
    }
}
