import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DropDown {
    public static void main(String[]args){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        WebElement dropCountry = driver.findElement(By.xpath("//select[@id='country']"));


        //need to use the select object passing in the web element location
        Select dropCountrySelect = new Select(dropCountry);
        dropCountrySelect.getOptions();

//        System.out.println(dropCountry.getText());//prints options

//        for(WebElement web: dropCountrySelect.getOptions()){//print options using select
//            System.out.println(web.getText());
//        }


        //select by index
        dropCountrySelect.selectByIndex(0);
        System.out.println(dropCountrySelect.getFirstSelectedOption().getText());//prints out what option is selected

        //needs value tag in html
        dropCountrySelect.selectByValue("japan");
        System.out.println(dropCountrySelect.getFirstSelectedOption().getText());

        //select by text (This will always be the easiest)
        dropCountrySelect.selectByVisibleText("Brazil");
        System.out.println(dropCountrySelect.getFirstSelectedOption().getText());


    }
}
