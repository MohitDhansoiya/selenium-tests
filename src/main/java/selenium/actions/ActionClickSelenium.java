package selenium.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.PriorityQueue;

public class ActionClickSelenium {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Thic PC\\IdeaProjects\\selenium-java\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void after() {
//        driver.quit();
    }

    @Test
    public void dragAndDropActionTest() {
        WebElement sourceElement = driver.findElement(By.xpath("//div[@id=\"simpleDropContainer\"]//div[@id=\"draggable\"]"));
        WebElement destinationElement = driver.findElement(By.xpath("//div[@id=\"simpleDropContainer\"]//div[@id=\"droppable\"]"));
        WebElement dropStatus = driver.findElement(By.xpath("//div[@id=\"simpleDropContainer\"]//div[@id=\"droppable\"]/p"));
        String statusBeforeDrop = dropStatus.getText();
        Assert.assertEquals(statusBeforeDrop, "Drop here");
        Actions actions = new Actions(driver);
        actions.dragAndDrop(sourceElement, destinationElement).perform();
        String statusAfterDrop = dropStatus.getText();
        Assert.assertEquals(statusAfterDrop, "Dropped!");

    }
    @Test
    public void dragAndDropAcceptTest(){
        WebElement sourceElement = driver.findElement(By.xpath("//div[@id=\"acceptable\"]"));
        WebElement destinationElement = driver.findElement(By.xpath("//div[@id=\"simpleDropContainer\"]/div[@class=\"drop-box ui-droppable\"]"));
        WebElement dropStatus = driver.findElement(By.xpath("//div[@id=\"simpleDropContainer\"]/div[@class=\"drop-box ui-droppable\"]/p"));
        String statusBeforeDropAccept = dropStatus.getText();
        Assert.assertEquals(statusBeforeDropAccept,"Acceptable");
        Actions action = new Actions(driver) ;
        action.dragAndDrop(sourceElement,destinationElement).perform();
        String statusAfterDrop = dropStatus.getText();
        Assert.assertEquals(statusAfterDrop,"Dropped!");
    }
    @Test
    public void dragAndDropPrevent(){
        WebElement sourceElement = driver.findElement(By.xpath("//div[@id=\"dragBox\"]"));
        WebElement destinationElement = driver.findElement(By.xpath("//div[@id=\"notGreedyInnerDropBox\"]"));
        WebElement dropStatus = driver.findElement(By.xpath("//div[@id=\"notGreedyInnerDropBox\"]/p"));
        String statusBeforePrevent = dropStatus.getText();
        Assert.assertEquals(statusBeforePrevent,"Drag Me");
        Actions actions = new Actions(driver);
        actions.dragAndDrop(sourceElement,destinationElement).perform();
        String statusAfterDropMe = dropStatus.getText();
        Assert.assertEquals(statusAfterDropMe,"Dropped!");
    }
    @Test
    public void dragAndDropRevert(){
        WebElement sourceElement = driver.findElement(By.xpath("//div[@id=\"notRevertable\"]"));
        WebElement destinationElement = driver.findElement(By.xpath("//div[@id=\"revertableDropContainer\"]//div[@class=\"drop-box ui-droppable\"]"));
        WebElement dargAndGrop = driver.findElement(By.xpath(""));
    }
}
