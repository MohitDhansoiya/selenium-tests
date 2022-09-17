package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonWristWatchTest extends TestBase{

    @Test
    public void WristWatchSearch() {
        String baseurl = "https://www.amazon.in/";
        driver.get(baseurl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getElement(driver,"XPATH","//input[@id=\"twotabsearchtextbox\"]").sendKeys("wrist watches");
        click(driver,"XPATH","//input[@id=\"nav-search-submit-button\"]");
        click(driver,"XPATH","//span[text()=\"Analogue\"]");
        click(driver,"XPATH","//span[text()=\"Leather\"]");
        waitForPageLoad(driver);
        click(driver,"XPATH","//a[@aria-label=\"See more, Brands\"]/span[@class=\"a-expander-prompt\"]");
        click(driver,"XPATH","//li[@aria-label=\"Titan\"]//a");
        click(driver,"XPATH","//span[text()='Discount']/parent::div/following::ul//span[contains(text(),'25% Off or more')]");
        String xPathSerachResults = "//span[@data-component-type=\"s-product-image\"]//img";
        List<WebElement> listOfWatches =  getElements(driver,"XPATH",xPathSerachResults);
        while (listOfWatches.size()<5) {
            listOfWatches =  getElements(driver,"XPATH",xPathSerachResults);
        }
        WebElement fifthWatch = listOfWatches.get(4);
        System.out.println("Fifth Watch description -> " + fifthWatch.getAttribute("alt"));
        Assert.assertEquals(fifthWatch.getAttribute("alt"),"Titan Classique Analog Silver Dial Men's Watch-NM90100SL01 / NL90100SL01");
    }

}
