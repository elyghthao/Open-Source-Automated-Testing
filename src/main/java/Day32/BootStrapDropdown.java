package Day32;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class BootStrapDropdown {
    public static void main(String[]args){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");

        //select single option
        WebElement dropDownWeb = driver.findElement(By.xpath("//button[@class='multiselect dropdown-toggle btn btn-default']"));
        dropDownWeb.click();//opens up the all of the options

        //1) select single option
        driver.findElement(By.xpath("//input[@value='Java']")).click();

        //2) capture all the options and find out size

        //finds all the labels related to the checkboxes
        List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//li//label"));
        System.out.println("number of options: " + options.size());

        //go through each of the options
        for(WebElement o: options){
            System.out.println(o.getText());

            //verifies if option is a checkbox and if the input is selected or not
            //if input is unselected, go ahead and click
            if(o.getAttribute("class").equals("checkbox") &&
            !o.findElement(By.xpath(".//input")).isSelected()){
                System.out.println(o.getText());
                o.findElement(By.xpath(".//input")).click();
            }

        }

    }
}