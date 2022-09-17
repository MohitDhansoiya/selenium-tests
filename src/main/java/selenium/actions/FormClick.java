package selenium.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FormClick {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Thic PC\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String baseurl = "https://demoqa.com/automation-practice-form";
        driver.get(baseurl);
        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//        Thread.sleep(30000);
        WebElement firstName = driver.findElement(By.xpath("//input[@id=\"firstName\"]"));
        firstName.sendKeys("Mohit");
        String name = firstName.getText();
        WebElement lastName = driver.findElement(By.xpath("//input[@id=\"lastName\"]"));
        lastName.sendKeys("Dhansoiya");
        String last = lastName.getText();
        WebElement email = driver.findElement(By.xpath("//input[@id=\"userEmail\"]"));
        email.sendKeys("Mohit160161gmail.com");
        String Email = email.getText();
        WebElement button = driver.findElement(By.xpath("//label[@for=\"gender-radio-1\"]"));
        button.click();
        WebElement mobile = driver.findElement(By.xpath("//input[@id=\"userNumber\"]"));
        mobile.sendKeys("9996160161");
        String number = mobile.getText();
//        WebElement dateOfbirth = driver.findElement(By.xpath("//input[@value=\"17 Mar 2022\"]"));
//        dateOfbirth.clear();
//        dateOfbirth.sendKeys("5 oct 1993");
//        String date = dateOfbirth.getText();
        WebElement sub = driver.findElement(By.xpath("//div[@class=\"subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3\"]"));
        sub.sendKeys("Math");
        String Subject = sub.getText();
        WebElement hob = driver.findElement(By.xpath("//label[@for=\"hobbies-checkbox-1\"]"));
        hob.click();
        WebElement pic = driver.findElement(By.xpath("//input[@id=\"uploadPicture\"]"));
        pic.sendKeys("WIN_20210114_19_14_08_Pro");
        String Picture = pic.getText();
        WebElement address = driver.findElement(By.xpath("//input[@id=\"currentAddress\"]"));
        address.sendKeys("gali no 1 raghuveer vihar");
        String Address = address.getText();
//       WebElement  driver.findElement(By.xpath("//div[@class=\" css-tlfecz-indicatorContainer\"]")).click();
//        driver.findElement(By.xpath("//div[@class=\" css-tlfecz-indicatorContainer\"]")).click();
    }
}


//Java_CODE (click) -> chrome driver 90 -> Google Chrome browser - 95
