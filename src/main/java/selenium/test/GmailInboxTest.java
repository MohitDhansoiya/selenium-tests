package selenium.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GmailInboxTest extends TestBase{

    @Test
    public void verifyEmailInSocialLabel() {
        String applicationUrl = "https://www.google.com/intl/en-GB/gmail/about/";
        String projectDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",projectDir+"\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(applicationUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        click(driver, "XPATH","//a[text()='Sign in']");
        getElement(driver,"XPATH","//input[@aria-label=\"Email or phone\"]").sendKeys("EMAIL");
        click(driver,"XPATH","//span[text()='Next']");


    }
}
