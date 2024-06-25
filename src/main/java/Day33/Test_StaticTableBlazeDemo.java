package Day33;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Test_StaticTableBlazeDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://blazedemo.com");

        //1)Depart from San Diego and arrive at New York
        Select departure = new Select (driver.findElement(By.xpath("//select[@name='fromPort']")));
        departure.selectByVisibleText("San Diego");
        Select destination = new Select(driver.findElement(By.xpath("//select[@name='toPort']")));
        destination.selectByVisibleText("New York");
        driver.findElement(By.xpath("//input")).click();

        //2)Pick the Lowest Cost Flight
        double lowestCost = Double.MAX_VALUE;
        WebElement curFlight = null;
        int rows = driver.findElements(By.xpath("//table//tbody//tr")).size();
        for(int r=1; r<= rows;r++){
            String cost = driver.findElement(By.xpath("//table//tr["+r+"]//td[6]")).getText();
            double realCost = Double.parseDouble(cost.substring(1));
            lowestCost = Double.min(lowestCost,realCost);
            if(lowestCost == realCost){
                curFlight = driver.findElement(By.xpath("//table//tr["+r+"]"));
            }
//            System.out.println("lowestCost: " + lowestCost + "     realCost: " + realCost);
        }
        try{
            assert curFlight != null;
            curFlight.findElement(By.xpath(".//input[@type='submit']")).click();
        }catch (Exception ignored){}

        //3)Enter in personal data
        driver.findElement(By.id("inputName")).sendKeys("Elygh Thao");
        driver.findElement(By.id("address")).sendKeys("2724 28th Ave S");
        driver.findElement(By.id("city")).sendKeys("Kent");
        driver.findElement(By.id("state")).sendKeys("Washington");
        driver.findElement(By.id("zipCode")).sendKeys("98035");
        driver.findElement(By.id("creditCardNumber")).sendKeys("1234 5678 9101 1111");
        driver.findElement(By.id("creditCardMonth")).sendKeys("10");
        driver.findElement(By.id("creditCardYear")).sendKeys("2025");
        driver.findElement(By.id("nameOnCard")).sendKeys("Elygh Thao");
        driver.findElement(By.id("rememberMe")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

    }
}
