package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;


/*
1) Launch browser
2) open url
	https://opensource-demo.orangehrmlive.com/
3) Provide username  - Admin
4) Provide password  - admin123
5) Click on Login button
6) Verify the title of dashboard page
	Exp title : OrangeHRM
7) close browser
*/
public class OrangeHRMLoginTest {
    public static void main(String[]args) throws InterruptedException {



        //1)launch browser
        WebDriver driver=new ChromeDriver();//always use webdriver



        //2) Open url on the browser
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
//        Thread.sleep(5000);


        //3) provide the username
        while(true){
            try{
                driver.findElement(By.name("username")).sendKeys("Admin");
                break;
            }catch (Exception ignored){}
        }

        //4)Provide password
        driver.findElement(By.name("password")).sendKeys("admin123");

        //5) Click on Login Button
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();


        //6) verify the title of dashboard page
        String act_title = driver.getTitle();
        String exp_title = "OrangeHRM";

        if(act_title.equals(exp_title)){
            System.out.println("Test passed");
        }else {
            System.out.println("Test failed");
        }

        //7) close browser
        driver.quit();



    }


}
