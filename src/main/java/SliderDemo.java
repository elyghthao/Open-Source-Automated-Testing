import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class SliderDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        Actions act = new Actions(driver);

        WebElement minSlider = driver.findElement(By.xpath("//div[@class='price-range-block']//span[1]"));


        System.out.println("cur pos of minSlider: "+ minSlider.getLocation());

        //drag and drop the slider based on web element page axis (moving left 100 units)
//        act.dragAndDropBy(minSlider, 100, 0).build().perform();


        //control the slider using arrow keys
        minSlider.click();
        for(int i = 0; i < 80;i++){
            act.keyDown(Keys.ARROW_RIGHT).build().perform();
        }


        System.out.println("cur pos of minSlider: "+ minSlider.getLocation());
    }
}
