package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AmazonWrist1 {
    
    public void wristWatches(){
        String projectDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",projectDir+"\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String baseurl = "https://www.amazon.in/";
        driver.get(baseurl);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("iphone 13pro 512gb");
        driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]")).click();
        driver.findElement(By.xpath("//span[text()=\"Brands\"]")).click();
        driver.findElement(By.xpath("//span[text()=\"Apple\"]")).click();
        driver.findElement(By.xpath("//span[text()=\"Apple iPhone 13 Pro (512 GB) - Alpine Green\"]")).click();
        driver.findElement(By.xpath("//span[@id=\"size_name_3-announce\"]")).click();
        driver.findElement(By.xpath(""));
    }
}
