package selenium.navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Navigation2 {
    WebDriver driver;
    @BeforeTest
    public void setUpTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Thic PC\\IdeaProjects\\selenium-java\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.javatpoint.com/object-and-class-in-java");
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getTitle(),"Object in Java | Class in Java - javatpoint");
    }
    @Test(priority = 0)
    public void navigateExample(){
        System.out.println("Navigate To Test");
        driver.navigate().to("https://www.javatpoint.com/java-programs");
        Assert.assertEquals(driver.getTitle(),"Java Programs | Java Programming Examples - Javatpoint");
    }
    @Test(priority = 1)
    public void backTo(){
        System.out.println("Navigate Back Test");
        driver.navigate().back();
        Assert.assertEquals(driver.getTitle(),"Object in Java | Class in Java - javatpoint");
    }
    @Test(priority = 2)
    public void forword(){
        System.out.println("Navigate Forward Test");
        driver.navigate().forward();
        Assert.assertEquals(driver.getTitle(),"Java Programs | Java Programming Examples - Javatpoint");
    }
    @Test(priority = 3)
    public void refresh(){
        System.out.println("Navigate Refresh Test");
        driver.navigate().refresh();
        Assert.assertEquals(driver.getTitle(),"Java Programs | Java Programming Examples - Javatpoint");
    }
    @AfterTest
    public void after(){
        driver.quit();
    }
}
