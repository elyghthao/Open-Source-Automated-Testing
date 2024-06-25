import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelectorsDemo {

    public static void main(String[]args){
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com");


        //tag and id
        WebElement s = driver.findElement(By.cssSelector("input[placeholder='Search store']"));
        s.sendKeys("MacBook");


        WebElement button = driver.findElement(By.cssSelector("button[class='button-2 product-box-add-to-cart-button']"));
        System.out.println(button.getText());
//        WebElement button = driver.findElement(By.cssSelector("submit")));
//        button.click();

    }
}
