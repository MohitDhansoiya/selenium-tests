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

public class FlipKartLaunch {
    WebDriver driver;
    JavascriptExecutor javascriptExecutor;
    WebDriverWait exlicitWait;

    @BeforeClass
    public void setUP() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Thic PC\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        exlicitWait = new WebDriverWait(driver, 20);
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    @Test
    public void launch() {
        driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("hersheys chochlate bars");
        driver.findElement(By.xpath("//div[@class=\"nav-right\"]//following-sibling::input[@id=\"nav-search-submit-button\"]")).click();
        String listOfFirstPage = "//div[@data-component-type=\"s-search-result\"]";
        List<WebElement> list = driver.findElements(By.xpath(listOfFirstPage));
        String total = list.get(47).getText();
        WebElement wbe = list.get(47);
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = {"launch"})
    public void pageSecond() {
//        WebElement nextpage = driver.findElement(By.xpath("//a[text()=\"Next\"]"));
//        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", nextpage);
        int noOfResults = 0;
        boolean flag = true;
        while (flag) {
            WebElement nextpage = driver.findElement(By.xpath("//a[text()=\"Next\"]"));
            javascriptExecutor.executeScript("arguments[0].scrollIntoView();", nextpage);
            if(nextpage.getAttribute("class").contains("disabled")) {
                flag = false;
            } else {
                javascriptExecutor.executeScript("arguments[0].click();", nextpage);
                String secondPage = "//div[@data-component-type=\"s-search-result\"][not(contains(@class,'AdHolder'))]";
                List<WebElement> secondList = driver.findElements(By.xpath(secondPage));
                System.out.println("Number of results - " + secondList.size());
                noOfResults = noOfResults + secondList.size();
            }
        }

//        while (!nextpage.getAttribute("class").contains("disabled")) {
//            javascriptExecutor.executeScript("arguments[0].click();", nextpage);
//            String secondPage = "//div[@data-component-type=\"s-search-result\"][not(contains(@class,'AdHolder'))]";
//            List<WebElement> secondList = driver.findElements(By.xpath(secondPage));
//            System.out.println("Number of results - " + secondList.size());
//            noOfResults = noOfResults + secondList.size();
//        }
        Assert.assertEquals(noOfResults, 276);
    }
}
