import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class CheckBox {
    public static void main (String[]args){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");


        //select checkbox
//        WebElement parent = driver.findElement(By.xpath("//div[@class='form-group']"));



        //finds all the child class of this section of the webpage and check marks all of them
//        WebElement parentEle = driver.findElement(By.xpath(("(//title[text()='Form Elements']/following-sibling::div)[4]")));
//        List<WebElement> checkboxes = parentEle.findElements(By.xpath("./child::*"));
//        for(WebElement w : checkboxes){
//            if(w.getTagName().equals("div")){
//                w.findElement(By.xpath(".//input")).click();
//            }
//        }

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input'][@type='checkbox']"));

        System.out.println(checkboxes.size());
        for(WebElement web: checkboxes){
            web.click();
        }



    }
}
