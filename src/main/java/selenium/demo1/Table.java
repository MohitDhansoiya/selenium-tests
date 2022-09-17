package selenium.demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class Table {
    WebDriver driver;

    @BeforeTest
    public void tableData() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Thic PC\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();
    }

    //    @Test
    public void lsitTable() {
        List<WebElement> list = driver.findElements(By.xpath("//div[@class=\"action-buttons\"]//ancestor::div[@class=\"rt-tr-group\"]/div"));
        for (int i = 0; i <= list.size() - 1; i++) {
//            WebElement element = list.get(i);
            List<WebElement> columns = driver.findElements(By.xpath("(//div[@class=\"action-buttons\"]//ancestor::div[@class=\"rt-tr-group\"]/div)[" + (i + 1) + "]//div[@class=\"rt-td\"]"));
            for (int j = 0; j <= columns.size() - 1; j++) {
                WebElement cell = columns.get(j);

                System.out.print(cell.getText());
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    @Test
    public void addUser() {
        driver.findElement(By.xpath("//button[@id=\"addNewRecordButton\"]")).click();
        driver.findElement(By.id("firstName")).sendKeys("Mohit");
        driver.findElement(By.id("lastName")).sendKeys("Jangra");
        driver.findElement(By.id("userEmail")).sendKeys("Mohit@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder=\"Age\"]")).sendKeys("28");
        driver.findElement(By.cssSelector("input[id=\"salary\"]")).sendKeys("15000");
        driver.findElement(By.cssSelector("input[placeholder=\"Department\"]")).sendKeys("HiveX");
        driver.findElement(By.cssSelector("button[id=\"submit\"]")).click();
        List<WebElement> list = driver.findElements(By.xpath("//div[@class=\"action-buttons\"]//ancestor::div[@class=\"rt-tr-group\"]/div"));
        for (int i = 0; i <= list.size() - 1; i++) {
            List<WebElement> columns = driver.findElements(By.xpath("(//div[@class=\"action-buttons\"]//ancestor::div[@class=\"rt-tr-group\"]/div)[" + (i + 1) + "]//div[@class=\"rt-td\"]"));
            if (columns.get(0).getText().equalsIgnoreCase("Mohit")) {
                Assert.assertEquals(columns.get(0).getText(), "Mohit");
                Assert.assertEquals(columns.get(1).getText(), "Jangra");
                Assert.assertEquals(columns.get(2).getText(), "28");
                Assert.assertEquals(columns.get(3).getText(), "Mohit@gmail.com");
                Assert.assertEquals(columns.get(4).getText(), "15000");
                Assert.assertEquals(columns.get(5).getText(), "HiveX");
            }
        }
    }

    @Test(dependsOnMethods = {"addUser"})
    public void editUser() {
//        String xpathEdit = "((//div[@class=\"action-buttons\"]//ancestor::div[@class=\"rt-tr-group\"]/div)[4]//div[@class=\"rt-td\"])[7]//span[@title=\"Edit\"]";
//        List<WebElement> rows = driver.findElements(By.xpath("//div[@class=\"action-buttons\"]//ancestor::div[@class=\"rt-tr-group\"]/div"));
//        for (int i = 0; i <= rows.size() - 1; i++) {
//            List<WebElement> columns = driver.findElements(By.xpath("(//div[@class=\"action-buttons\"]//ancestor::div[@class=\"rt-tr-group\"]/div)[" + (i + 1) + "]//div[@class=\"rt-td\"]"));
//            if (columns.get(0).getText().equalsIgnoreCase("Mohit")) {
//              driver.findElement(By.xpath(xpathEdit)).click();
//            }
//        }
        driver.findElement(By.xpath("//div[text()='Mohit']/following-sibling::div[6]//span[@title='Edit']")).click();

        WebElement name = driver.findElement(By.id("firstName"));
        name.clear();
        name.sendKeys("Mohit");
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.clear();
        lastName.sendKeys("Jangra");
        WebElement email = driver.findElement(By.id("userEmail"));
        email.clear();
        email.sendKeys("Mohit@gmail.com");
        WebElement age = driver.findElement(By.cssSelector("input[placeholder=\"Age\"]"));
        age.clear();
        age.sendKeys("30");
        WebElement salary = driver.findElement(By.cssSelector("input[id=\"salary\"]"));
        salary.clear();
        salary.sendKeys("20000");
        WebElement department = driver.findElement(By.cssSelector("input[placeholder=\"Department\"]"));
        department.clear();
        department.sendKeys("Zoho");
        driver.findElement(By.cssSelector("button[id=\"submit\"]")).click();
        List<WebElement> list = driver.findElements(By.xpath("//div[@class=\"action-buttons\"]//ancestor::div[@class=\"rt-tr-group\"]/div"));
        for (int i = 0; i <= list.size() - 1; i++) {
            List<WebElement> columns = driver.findElements(By.xpath("(//div[@class=\"action-buttons\"]//ancestor::div[@class=\"rt-tr-group\"]/div)[" + (i + 1) + "]//div[@class=\"rt-td\"]"));
            if (columns.get(0).getText().equalsIgnoreCase("Mohit")) {
                Assert.assertEquals(columns.get(0).getText(), "Mohit");
                Assert.assertEquals(columns.get(1).getText(), "Jangra");
                Assert.assertEquals(columns.get(3).getText(), "Mohit@gmail.com");
                Assert.assertEquals(columns.get(2).getText(), "30");
                Assert.assertEquals(columns.get(4).getText(), "20000");
                Assert.assertEquals(columns.get(5).getText(), "Zoho");
            }
        }
    }

    @Test
    public void deleteUser() {
        driver.findElement(By.xpath("//div[text()='Mohit']/following-sibling::div[6]//span[@title='Delete']")).click();
        List<WebElement> checkList = driver.findElements(By.xpath("//div[@class=\"action-buttons\"]//ancestor::div[@class=\"rt-tr-group\"]/div"));
        for (int i = 0; i <= checkList.size() - 1; i++) {
            List<WebElement> columns = driver.findElements(By.xpath("(//div[@class=\"action-buttons\"]//ancestor::div[@class=\"rt-tr-group\"]/div)[" + (i + 1) + "]//div[@class=\"rt-td\"]"));
            if (!columns.get(0).getText().equalsIgnoreCase("Mohit")) {
                System.out.println("List is right");

            }
        }
    }

    @Test
    public void removeUser() {
//        driver.findElement(By.xpath("//div[text()='Alden']/following-sibling::div[6]//span[@title='Delete']")).click();
        List<WebElement> list = driver.findElements(By.xpath("//div[@class=\"action-buttons\"]//ancestor::div[@class=\"rt-tr-group\"]/div"));
        for (int i = 0; i <= list.size() - 1; i++) {
            List<WebElement> columns = driver.findElements(By.xpath("(//div[@class=\"action-buttons\"]//ancestor::div[@class=\"rt-tr-group\"]/div)[" + (i + 1) + "]//div[@class=\"rt-td\"]"));
            if (!columns.get(0).getText().equalsIgnoreCase("Alden")) {
                for(int j =0; j<columns.size(); j++) {
                    System.out.print(columns.get(j).getText());
                    System.out.print("\t");
                }
                System.out.println();
            }
        }
    }
}


