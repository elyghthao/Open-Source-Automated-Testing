package Day36;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class KeyboardActions {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://text-compare.com/");
        Actions act = new Actions(driver);

        WebElement txtBox = driver.findElement(By.xpath("//textarea[@name='text1']"));
        txtBox.sendKeys("WELCOME");
        txtBox.click();

        //Ctrl+A  -selects the text
        act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).build().perform();

        //Ctrl+c   -copy the text
        act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).build().perform();

        //tab   -shift to 2nd box
        act.keyDown(Keys.TAB).build().perform();

        //Ctrl+v   -paste the text
        act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).build().perform();



        //make some feedback
        WebElement feedbackButton = driver.findElement(By.xpath("//a[text()='Feedback']"));
        act.keyDown(Keys.CONTROL).click(feedbackButton).keyUp(Keys.CONTROL).build().perform();//open link in new tab

        System.out.println("title: " + driver.getTitle());
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());//switch to the new tab
        driver.switchTo().window(windowHandles.get(1));
//        System.out.println(windowHandles.size());
        System.out.println("title: " + driver.getTitle());
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("This website is alright" +
                ", however i think it could use some more buttons to make certain features more accessible");

        //next step would be to click "Send feedback!", but there's no need to actually do it
    }
}
