import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class StaticTable {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement tableParent = driver.findElement(By.xpath("//table[@name='BookTable']"));

        //1) find total number of rows in a table
        int rows = tableParent.findElements(By.xpath(".//tr")).size();
        System.out.println("number of rows: " + rows);

        //2) find total number of columns in a table
        int col = tableParent.findElements(By.xpath(".//th")).size();
        System.out.println("number of cols: " + col);

        //3)Read data from specific row and column
        String r5c1 = tableParent.findElement(By.xpath(".//tr[5]//td[1]")).getText();
        System.out.println("row 5, col 1: " + r5c1);

        //4)Read data from all the rows and columns
        driver.findElements(By.xpath("//table[@name='BookTable']//tr[1]//th")).forEach(
                (n)-> {
                    System.out.print(n.getText() + "\t");//this prints headers
                }
        );
        for(int r = 2;r<=rows;r++){
            for(int c = 1;c<=col;c++) {
                String txt = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[" + c + "]")).getText();
                System.out.print(txt + "\t");
            }
            System.out.println();
        }


    }
}
