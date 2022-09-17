package selenium.demo1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Alerts {
    WebDriver driver;
    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Thic PC\\IdeaProjects\\selenium-java-maven\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void alertTest() {

        WebElement alert1 = driver.findElement(By.xpath("//button[@id=\"alertButton\"]"));
        alert1.click();
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        System.out.println("Alert message - " + alertMessage);
        Assert.assertEquals(alertMessage,"You clicked a button");
        alert.accept();
    }
    @Test
    public void alert2(){
        WebElement alert2 = driver.findElement(By.xpath("//button[@id=\"timerAlertButton\"]"));
        alert2.click();
        Alert promptAlert = driver.switchTo().alert();
        String promtAlert1 = promptAlert.getText();
        System.out.println("PromptAlert Message"+promtAlert1);
        Assert.assertEquals(promtAlert1,"This alert will appear after 5 seconds");
        promptAlert.accept();
    }
    @Test
    public void alert3(){
        WebElement alert3 = driver.findElement(By.xpath("//button[@id=\"confirmButton\"]"));
        alert3.click();
        Alert actionAlert = driver.switchTo().alert();
        String actionAlert1 = actionAlert.getText();
        System.out.println("Action Alert"+ actionAlert1);
        Assert.assertEquals(actionAlert1,"Do you confirm action?");
        actionAlert.accept();
        String ok = driver.findElement(By.xpath("//span[@id=\"confirmResult\"]")).getText();
        Assert.assertEquals(ok,"You selected Ok");
        driver.findElement(By.xpath("//button[@id=\"confirmButton\"]")).click();
        actionAlert.dismiss();
        ok = driver.findElement(By.xpath("//span[@id=\"confirmResult\"]")).getText();
        Assert.assertEquals(ok,"You selected Cancel");

    }
    @Test
    public void alert4(){
        WebElement alert4 = driver.findElement(By.xpath("//button[@id=\"promtButton\"]"));
        alert4.click();
        Alert textAction =  driver.switchTo().alert();
        String giveText = textAction.getText();
        System.out.println("Text Action:"+giveText);
        Assert.assertEquals(giveText,"Please enter your name");
        textAction.sendKeys("Mohit");
        textAction.accept();
    }
}

