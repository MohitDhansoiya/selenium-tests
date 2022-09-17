package selenium.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Form2 {
    @Test
    public void registrationForm() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Thic PC\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        WebElement firstName = driver.findElement(By.xpath("//input[@placeholder=\"First Name\"]"));
        firstName.sendKeys("Mohit");
        String name = firstName.getText();
        WebElement lastName = driver.findElement(By.xpath("//input[@id=\"lastName\"]"));
        lastName.sendKeys("jangra");
        String last  = lastName.getText();
        WebElement email = driver.findElement(By.xpath("//input[@class=\"mr-sm-2 form-control\"]"));
        email.sendKeys("mohit160161@");
        String emails = email.getText();
        WebElement gender = driver.findElement(By.xpath("//label[@for=\"gender-radio-3\"]"));
        gender.click();
        WebElement mobile = driver.findElement(By.xpath("//input[@id=\"userNumber\"]"));
        mobile.sendKeys("469871235");
        String number = mobile.getText();
        WebElement date = driver.findElement(By.xpath("id=\"dateOfBirthInput\""));
        date.sendKeys("30 april 2021");
        String dateNo = date.getText();
        WebElement sub = driver.findElement(By.xpath("//input[@id=\"subjectsInput\"]"));
        sub.sendKeys("Sports certificate");
        String subject = sub.getText();
        WebElement hob = driver.findElement(By.xpath("//input[@id=\"hobbies-checkbox-3\"]"));
        hob.click();
        WebElement pic =  driver.findElement(By.xpath("//input[@id=\"uploadPicture\"]"));
        pic.sendKeys("WIN_20210114_19_14_08_Pro");
        String photo = pic.getText();
        WebElement address = driver.findElement(By.xpath("//textarea[@placeholder=\"Current Address\"]"));
        address.sendKeys("karnal");
        String Address = address.getText();
    }
}
