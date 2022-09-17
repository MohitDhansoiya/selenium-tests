package selenium.alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertSeleniumTest {
    WebDriver driver;

    @BeforeTest
    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Thic PC\\IdeaProjects\\selenium-java\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void simpleAlertTest() {
        driver.findElement(By.xpath("//button[@id=\"alertButton\"]")).click();
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();
    }

    @Test
    public void timerAlertTest() {
        driver.findElement(By.xpath("//button[@id=\"timerAlertButton\"]")).click();
        ThreadWait(7000);
        Alert promptAlert = driver.switchTo().alert();
        String alertText = promptAlert.getText();
        System.out.println("Alert is Text:"+alertText);
        Assert.assertEquals(alertText,"This alert appeared after 5 seconds");
//        promptAlert.sendKeys("Testuser");
        promptAlert.accept();

    }

    @Test
    public void confirmAlertTest() {
        driver.findElement(By.xpath("//button[@id=\"confirmButton\"]")).click();
        Alert confirmationsAlert = driver.switchTo().alert();
        String alertText1= confirmationsAlert.getText();
        System.out.println("Alert Text:"+alertText1);
        Assert.assertEquals(alertText1,"Do you confirm action?");
        confirmationsAlert.accept();
        String ok = driver.findElement(By.xpath("//span[@id=\"confirmResult\"]")).getText();
        Assert.assertEquals(ok,"You selected Ok");
        driver.findElement(By.xpath("//button[@id=\"confirmButton\"]")).click();
        confirmationsAlert.dismiss();
        ok = driver.findElement(By.xpath("//span[@id=\"confirmResult\"]")).getText();
        Assert.assertEquals(ok,"You selected Cancel");
    }

    @Test
    public void promptAlertTest() {
        driver.findElement(By.xpath("//button[@id=\"promtButton\"]")).click();
        Alert ale = driver.switchTo().alert();
        String alertAle = ale.getText();
        System.out.println("Alert propmt:"+alertAle);
        Assert.assertEquals(alertAle,"Please enter your name");
        ThreadWait(2000);
        ale.sendKeys("Mohit");
        ale.dismiss();



    }

    public void ThreadWait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
