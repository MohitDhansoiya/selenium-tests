package selenium.demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonLaunch {
    WebDriver driver;
    JavascriptExecutor javascriptExecutor;
    WebDriverWait exlicitWait;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Thic PC\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        exlicitWait = new WebDriverWait(driver, 20);
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    @Test
    public void launch() throws InterruptedException {
        WebElement search = driver.findElement(By.xpath("//input[@dir=\"auto\"]"));
        javascriptExecutor.executeScript("arguments[0].value='men wrist watches';", search);
        WebElement button = driver.findElement(By.xpath("//div[@class=\"nav-right\"]//following-sibling::input[@id=\"nav-search-submit-button\"]"));
        javascriptExecutor.executeScript("arguments[0].click();", button);
        driver.findElement(By.xpath("//div[@id=\"brandsRefinements\"]//following-sibling::span[text()=\"Brand\"]"));
        driver.findElement(By.xpath("//li[@aria-label=\"TIMEX\"]//a")).click();
        WebElement display = driver.findElement(By.xpath("//li[@aria-label=\"Analogue\"]//a"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", display);
        javascriptExecutor.executeScript("arguments[0].click();", display);
        String xPathBandMatrial = "//span[text()='Band Material']/parent::div/following-sibling::ul[1]/li[@aria-label=\"Fabric\"]//a";
        WebElement material = driver.findElement(By.xpath(xPathBandMatrial));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", material);
        javascriptExecutor.executeScript("arguments[0].click();", material);
        String ceramicWatchList = "//div[@class=\"s-main-slot s-result-list s-search-results sg-row\"]//span[@class=\"a-size-base-plus a-color-base a-text-normal\"]";
        List<WebElement> listOfWatches = driver.findElements(By.xpath(ceramicWatchList));
        String timex = listOfWatches.get(3).getText();
        WebElement wbe = listOfWatches.get(3);
        wbe.click();

        Assert.assertEquals(timex,"MK1 Analog Grey Dial Men's Watch-TW2R68300");
    }
}

