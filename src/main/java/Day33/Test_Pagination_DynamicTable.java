package Day33;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_Pagination_DynamicTable {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://money.rediff.com/gainers/bse/daily/groupall");

        //Test Case 1
        //1) Read all data on Daily, Weekly and Monthly wise (From Gainers)
        System.out.println("DAILY");
        int rows = driver.findElements(By.xpath("//tr")).size();
        int cols = driver.findElements(By.xpath("//tr[1]//td")).size();
        System.out.println("rows: " + rows + "     cols: " + cols);


        for(int r=1;r<=rows/10;r++){
            WebElement company = driver.findElement(By.xpath("//table[@class='dataTable']//tbody//tr["+r+"]"));
            String name = company.findElement(By.xpath(".//td[1]//a")).getText();
            String group = company.findElement(By.xpath(".//td[2]")).getText();
            String change = company.findElement(By.xpath(".//td[5]")).getText();

            System.out.println(name + "|\t" + group + "|\t" + change + "%");
        }

        //2) In each group print company name which is having lowest %Change
    }
}
