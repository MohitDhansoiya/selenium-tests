package selenium.demo1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationFormTest {

    @Test
    public void registerTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Thic PC\\IdeaProjects\\selenium-java-maven\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String fName = "Gautam";
        WebElement firstName = driver.findElement(By.xpath("//input[@placeholder=\"First Name\"]"));
        firstName.sendKeys(fName);
        String lName = "Jangra";
        WebElement lastName = driver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]"));
        lastName.sendKeys(lName);

        String Email = "Mohit160161@gmail.com";
        WebElement email = driver.findElement(By.xpath("//input[@placeholder=\"name@example.com\"]"));
        email.sendKeys(Email);

        String Gender = "Male";
        WebElement gender = driver.findElement(By.xpath("//label[text()=\"Male\"]"));
        String stGender = gender.getText();
        gender.click();
        String mobileNo = "9996151141";
        WebElement mobile = driver.findElement(By.xpath("//input[@placeholder=\"Mobile Number\"]"));
        mobile.sendKeys(mobileNo);
        String sub1 ="Account";
        WebElement subject = driver.findElement(By.id("subjectsInput"));
        subject.sendKeys(sub1);
        subject.sendKeys(Keys.ENTER);

        Thread.sleep(5000);
        String currentAddress = "House number 1000, sector 1, Karnal";
        WebElement address = driver.findElement(By.id("currentAddress"));
        address.sendKeys(currentAddress);
        String stateName = "Haryana";
        WebElement state = driver.findElement(By.xpath("//input[@id=\"react-select-3-input\"]"));
        state.sendKeys(stateName);
        state.sendKeys(Keys.ENTER);
        state.getText();
        String cityName = "Karnal";
        WebElement city = driver.findElement(By.xpath("//input[@id=\"react-select-4-input\"]"));
        city.sendKeys(cityName);
        city.sendKeys(Keys.ENTER);
        city.getText();
        Thread.sleep(2000);
        WebElement submit = driver.findElement(By.xpath("//button[@id=\"submit\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",submit);

            WebElement title = driver.findElement(By.xpath("//div[@id=\"example-modal-sizes-title-lg\"]"));
            Assert.assertEquals("Thanks for submitting the form",title.getText() );
            WebElement studentName = driver.findElement(By.xpath("//td[text()=\"Student Name\"]/following-sibling::td"));
            Assert.assertEquals(fName +" "+lName,studentName.getText());
            WebElement studentEmail = driver.findElement(By.xpath("//td[text()=\"Student Email\"]/following-sibling::td"));
            Assert.assertEquals(Email,studentEmail.getText());
            WebElement studentGender = driver.findElement(By.xpath("//td[text()=\"Gender\"]/following-sibling::td"));
            Assert.assertEquals(stGender, studentGender.getText());
            WebElement studentMobile = driver.findElement(By.xpath("//td[text()=\"Mobile\"]/following-sibling::td"));
            Assert.assertEquals(mobileNo,studentMobile.getText());
            WebElement studentSubject = driver.findElement(By.xpath("//td[text()=\"Subjects\"]/following-sibling::td"));
            Assert.assertTrue(studentSubject.getText().contains(sub1));
            WebElement studentAddress = driver.findElement(By.xpath("//td[text()=\"Address\"]/following-sibling::td"));
            Assert.assertEquals(currentAddress,studentAddress.getText());
            WebElement stateAndCity = driver.findElement(By.xpath("//td[text()=\"State and City\"]/following-sibling::td"));
            Assert.assertEquals(stateName + " "+cityName ,stateAndCity.getText());
    }
}
