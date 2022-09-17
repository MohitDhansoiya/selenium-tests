package selenium.demo1;

import collection.HasArrayList;
import com.google.inject.spi.Dependency;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;
    JavascriptExecutor javascriptExecutor;
    WebDriverWait explicitWait;

    @BeforeTest
    public void initialize() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Thic PC\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        explicitWait = new WebDriverWait(driver, 20);
        javascriptExecutor = (JavascriptExecutor) driver;


    }

    //    @Test
    public void userRegister() throws InterruptedException {
        driver.findElement(By.cssSelector("button[id=\"newUser\"]")).click();
        driver.findElement(By.xpath("//input[@placeholder=\"First Name\"]")).sendKeys("Mohit");
        driver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]")).sendKeys("Jangra");
        driver.findElement(By.xpath("//input[@placeholder=\"UserName\"]")).sendKeys("Mohit");
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("Mohit160@");
        driver.findElement(By.xpath("//button[@id=\"register\"]")).click();

    }

    @Test
    public void loginUser() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id=\"userName\"]")).sendKeys("MohitJangra");
        driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("Mohit160@");
        driver.findElement(By.xpath("//button[@id=\"login\"]")).click();
        String userName = driver.findElement(By.xpath("//label[@id=\"userName-value\"]")).getText();
        Assert.assertEquals("MohitJangra", userName);
        // Operation to delete all books
        WebElement deleteAllBooks = driver.findElement(By.xpath("(//button[text()=\"Delete All Books\"])[1]"));
        javascriptExecutor.executeScript("arguments[0].click();", deleteAllBooks);
        driver.findElement(By.xpath("//button[@id=\"closeSmallModal-ok\"]")).click();
        explicitWait.until(ExpectedConditions.alertIsPresent());
        Alert alert5 = driver.switchTo().alert();
        String deleteBooks = alert5.getText();
        explicitWait.until(ExpectedConditions.alertIsPresent());

        alert5.accept();

//        explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    @Test(dependsOnMethods = {"loginUser"})
    public void searchBookTest() throws InterruptedException {
        WebElement gotoBookStoreElement = driver.findElement(By.xpath("//button[@id=\"gotoStore\"]"));
        javascriptExecutor.executeScript("arguments[0].click();", gotoBookStoreElement);
        driver.findElement(By.xpath("//input[@placeholder=\"Type to search\"]")).sendKeys("JavaScript");
        List<WebElement> list = driver.findElements(By.xpath("//div[@class=\"action-buttons\"]//ancestor::div[@class=\"rt-tr-group\"]//div"));
        for (int i = 0; i <= list.size() - 1; i++) {
            List<WebElement> columns = driver.findElements(By.xpath("//div[@class=\"action-buttons\"]//ancestor::div[@class=\"rt-tr-group\"]//div[\"+(i+1)+\"]//div[@class=\"rt-td\"]"));
            if (columns.get(1).getText().contains("JavaScript")) {
                System.out.println("List is valid");
            } else {
                System.out.println("List is invalid");
            }
        }
    }

    @Test(dependsOnMethods = {"loginUser"})
    public void addBookTest() {
        List<String> books = new ArrayList<>();
        books.add("Git Pocket Guide");
        books.add("Speaking JavaScript");
            boolean flag = false;
            for (String book : books) {
                System.out.println(book + " to add.......................");

                WebElement goToBookStore = driver.findElement(By.xpath("//button[contains(text(),'To Book Store')]"));
                javascriptExecutor.executeScript("arguments[0].click();", goToBookStore);
                driver.findElement(By.xpath("//input[@id=\"searchBox\"]")).clear();
                driver.findElement(By.xpath("//input[@id=\"searchBox\"]")).sendKeys(book);
                driver.findElement(By.xpath("//a[text()='" + book + "']")).click();
                WebElement addtoYourCollection = driver.findElement(By.xpath("//button[text()=\"Add To Your Collection\"]"));
                javascriptExecutor.executeScript("arguments[0].click();", addtoYourCollection);
                explicitWait.until(ExpectedConditions.alertIsPresent());
                Alert alert7 = driver.switchTo().alert();
                String alertMessage = alert7.getText();
                System.out.println("Alert Message:" + alertMessage);
                Assert.assertEquals(alertMessage, "Book added to your collection.");
                alert7.accept();
                explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'To Book Store')]")));

                System.out.println(book + " added.......................");

            }
        // to go profile
        WebElement profile = driver.findElement(By.xpath("//span[text()=\"Profile\"]"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", profile);
        driver.findElement(By.xpath("//span[text()=\"Profile\"]")).click();
        for(int i = 0; i < books.size();i++){
            List<WebElement> colums = driver.findElements(By.xpath("//div[@class=\"rt-tbody\"]/div//span/a"));
            if(colums.get(0).getText().equalsIgnoreCase(books.get(1))){
                System.out.println("List is valid");
            }else{
                System.out.println("List is not valid");
            }
        }
        List<WebElement> colums = driver.findElements(By.xpath("//div[@class=\"rt-tbody\"]/div//span/a"));
        for (int j = 0; j < colums.size();j++){
            System.out.println(colums.get(j).getText());
            if(books.contains(colums.get(j).getText())) {
                System.out.println("Book found");
                Assert.assertTrue(books.contains(colums.get(j).getText()));
            }
            else
                System.out.println(colums.get(j).getText() + " not found in " + books);
        }

        List<String> actualBooks = new ArrayList<>();
        for (WebElement element : colums) {
            String bookName = element.getText();
            actualBooks.add(bookName);
        }
        Assert.assertEquals(books,actualBooks);
    }

//    @Test(dependsOnMethods = {"addBookTest"})
    public void deleteBookTest() throws InterruptedException {

        WebElement profile = driver.findElement(By.xpath("//span[text()=\"Profile\"]"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", profile);
        driver.findElement(By.xpath("//span[text()=\"Profile\"]")).click();

        driver.findElement(By.xpath("//a[text()=\"Speaking JavaSt\"]//ancestor::div[@class=\"rt-td\"]//following-sibling::div[3]//span")).click();
        Alert book = driver.switchTo().alert();
        String deleteBook = book.getText();
        System.out.println("Delete Book" + deleteBook);
        Assert.assertEquals(deleteBook, "Do you want to delete this book?");
        book.accept();
    }
}



