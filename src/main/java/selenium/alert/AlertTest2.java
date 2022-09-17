package selenium.alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.TableHeaderUI;

public class AlertTest2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Thic PC\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        String baseurl = "https://demo.guru99.com/test/delete_customer.php";
        String baseurl = "https://www.javatpoint.com/selenium-webdriver-navigation-commands";
        driver.get(baseurl);
        driver.manage().window().maximize();
        driver.navigate().refresh();
//        driver.findElement(By.xpath("//input[@name=\"cusid\"]")).sendKeys("mohit160161");
//        driver.findElement(By.xpath("//input[@value=\"Submit\"]")).click();
//        driver.switchTo().alert().accept();
//        Thread.sleep(500);
    }
}
