import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class handleCaptcha {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new");//setting for headless mode of execution

        WebDriver driver= new ChromeDriver(options);


//        driver.get();w
    }
}
