package Day39;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

// if status code >= 400, is a broken link
//if status code <400, not a broken link

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new");
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("http://www.deadlinkcity.com/");

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("link size: " + links.size());
        int numOfBrokLnks = 0;
        for(WebElement link:links){
            String hrefttValue = link.getAttribute("href");
            if(hrefttValue==null || hrefttValue.isEmpty()){
                System.out.println("href attribute value is null or empty. So not possible to check ");
                continue;
            }

            try{
                //hit url to server
                URL linkURL = new URL(hrefttValue);//converted href value from string to URL format
                HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection();//opens connection to the server
                conn.connect(); //connect to server and sent request to the server

                System.out.print(hrefttValue +": ");
                if (conn.getResponseCode() >= 400) {
                    System.out.println("Broken Link");
                    numOfBrokLnks++;
                } else {
                    System.out.println("Not a Broken Link");
                }
            }catch(Exception ignored){
            }
        }
        System.out.println("Total Number of Broken Links: " + numOfBrokLnks);
        //broken link is a link which doesn't have any resources in the server
        //returns a response code with a number greater than or equal to 400

//        driver.quit();
    }
}
