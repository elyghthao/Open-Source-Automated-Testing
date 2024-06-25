import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AuthenticatedPopup {

    public static void main(String[]args){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        driver.get("http://the-internet.herokuapp.com/basic_auth");


        //requires authenticated popup, have to use a different url
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth"); //username and password are admin and admin



    }
}
