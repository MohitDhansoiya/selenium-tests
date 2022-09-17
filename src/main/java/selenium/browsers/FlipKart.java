package selenium.browsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

public class FlipKart {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver","C:\\Users\\Thic PC\\IdeaProjects\\selenium-java-maven\\drivers\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.flipkart.com");
        String expectedEmail = driver.findElement(By.xpath("//td[text()=\"Student Email\"]/following::td")).getText();
        Assert.assertEquals("gautam@gmail.com",expectedEmail);
    }
}
