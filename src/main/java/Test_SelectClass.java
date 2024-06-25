import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Test_SelectClass {
//    1) Handle country dropdown with/without  using Select class:
//    https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/
//    a) count total number of options
//    b) print all the options
//    c) select one option
    public static void main(String[]args){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
        Select countryDropdown = new Select(driver.findElement(By.xpath("//select[@id='country-list']")));

        List<WebElement> countryList = countryDropdown.getOptions();
        System.out.println("country size: " + countryList.size());
        countryList.forEach( (n) -> {
            System.out.println(n.getText());
        });
        countryDropdown.selectByVisibleText("France");



    }
}
