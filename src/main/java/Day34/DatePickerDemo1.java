package Day34;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DatePickerDemo1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://jqueryui.com/datepicker/");


        //switch to frame
        driver.switchTo().frame(0);

        //Method1 : using sendkeys(), will not always work
//        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("04/05/2024");


        //Method2 : using date picker
        //expected data
        String year="2032";
        String month="September";
        String day="9";
        driver.findElement(By.xpath("//input[@id='datepicker']")).click();//opens datepicker

        //select month
        while(true){
            String curMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();//actual month
            if(curMonth.equals(month)){
                break;
            }
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
        }
        Thread.sleep(2000);
        //select year
        while(true){
            String curYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            if(curYear.equals(year)){
                break;
            }
            if(((Integer.parseInt(curYear) < Integer.parseInt(year)))){
                for(int i = 0; i < 12; i++){
                    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
                }
            }else{
                for(int i = 0; i < 12; i++){
                    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
                }
            }
        }
        List<WebElement> dates = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']//tbody//a"));
        dates.forEach((n)->{
            if(n.getText().equals(day)){n.click();}
        });
    }
}
