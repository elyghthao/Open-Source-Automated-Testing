import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class GetMethods {

    public static void main(String[]args){
        WebDriver driver = new ChromeDriver();

//        get(url)
//        getTitle()
//        getCurrentURL()
//        getPageSource()
//        getWindowHandle()
//        getWindowHandles()

        //get(url)
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        //getTitle()
        System.out.println("title: " + driver.getTitle());

        //getCurrentURL()
        System.out.println("currentURL: " + driver.getCurrentUrl());

        //getPageSource()
//        System.out.println("pageSource: " + driver.getPageSource());

        //getWindowHandle()
        System.out.println("windowHandle: " + driver.getWindowHandle());

        //getWidowhandles()
        System.out.println("windowHandles: " + driver.getWindowHandles());
    }
}
