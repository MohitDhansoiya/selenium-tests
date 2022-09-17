package selenium.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FormFill {
    @Test
    public void registrationForm() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Thic PC\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Thic PC\\IdeaProjects\\selenium-java\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/Thic%20PC/Desktop/form.html");

        driver.manage().window().maximize();
        WebElement firstName = driver.findElement(By.xpath("//input[@title=\"enter your first name\"]"));
        firstName.sendKeys("Mohit");
        String firstNameString = firstName.getText();
        driver.findElement(By.xpath("//th[text()='Enter your last name']/parent::tr/td/input")).sendKeys("jangra");
        driver.findElement(By.xpath("//th[text() ='Enter your password' ]/parent::tr/td/input")).sendKeys("1235Anu");
        driver.findElement(By.xpath("//th[text() ='ReEnter your password' ]/parent::tr/td/input")).sendKeys("1235anu");
        driver.findElement(By.xpath("//th[text() ='Enter your email' ]/parent::tr/td/input")).sendKeys("mohit160161");
        driver.findElement(By.xpath("//th[text() ='Enter your mobile' ]/parent::tr/td/input")).sendKeys("654896545");
        driver.findElement(By.xpath("//th[text() ='Enter your address' ]/parent::tr/td/textarea")).sendKeys("karnal");
        driver.findElement(By.xpath("//th[text() ='Select your gender' ]/parent::tr/td/input[@value=\"f\"]")).click();
        driver.findElement(By.xpath("//input[@value=\"h2\"]")).click();
        driver.findElement(By.xpath("//input[@type=\"date\"]")).click();
        driver.findElement(By.xpath("//option[@value=\"1\"]")).click();
        driver.findElement(By.xpath("//input[@type=\"file\"]")).sendKeys("WIN_20210114_19_13_38_Pro");
        driver.findElement(By.xpath("//input[@value=\"Reset Data\"]")).click();
    }
}