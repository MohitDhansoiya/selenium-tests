package selenium.demo1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Watches {
    WebDriver driver;
    JavascriptExecutor javascriptExecutor;
    WebDriverWait exlicitWait;
    @BeforeClass
    public void pageAmazon(){
     System.setProperty("webdriver.chrome.driver","C:\\Users\\Thic PC\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        exlicitWait = new WebDriverWait(driver, 20);
        javascriptExecutor = (JavascriptExecutor) driver;
    }
    @Test
    public void loginAmzaon(){
        
    }
}
