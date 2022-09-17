package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver = null;

    @BeforeSuite
    public void setup() {
        String projectDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",projectDir+"\\drivers\\chromedriver.exe");
         this.driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void waitForPageLoad(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public void click(WebDriver driver, String locatorType, String locatorValue) {
        getElement(driver, locatorType, locatorValue).click();
        waitForPageLoad(driver);
    }

    public WebElement getElement(WebDriver driver, String locatorType, String locatorValue) {
        WebElement element = null;
        switch (locatorType.toUpperCase()) {
            case "XPATH":
                element = driver.findElement(By.xpath(locatorValue));
                break;
            case "CSS":
                element = driver.findElement(By.cssSelector(locatorValue));
                break;
            case "CLASS":
                element = driver.findElement(By.className(locatorValue));
                break;
            case "NAME":
                element = driver.findElement(By.name(locatorValue));
                break;
            case "ID":
                element = driver.findElement(By.id(locatorValue));
                break;
            default:
                System.out.println("No matching locator found ...");
                break;
        }
        return element;
    }

    public List<WebElement> getElements(WebDriver driver, String locatorType, String locatorValue) {
        List<WebElement> elements = null;
        switch (locatorType.toUpperCase()) {
            case "XPATH":
                elements = driver.findElements(By.xpath(locatorValue));
                break;
            case "CSS":
                elements = driver.findElements(By.cssSelector(locatorValue));
                break;
            case "CLASS":
                elements = driver.findElements(By.className(locatorValue));
                break;
            case "NAME":
                elements = driver.findElements(By.name(locatorValue));
                break;
            case "ID":
                elements = driver.findElements(By.id(locatorValue));
                break;
            default:
                System.out.println("No matching locator found ...");
                break;
        }
        return elements;
    }

}
