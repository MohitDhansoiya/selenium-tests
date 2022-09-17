package selenium.navigation;

import javafx.beans.property.SetProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameWebDriver {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Thic PC\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String baseurl = "https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame";
        driver.get(baseurl);
        driver.manage().window().maximize();
        WebElement frame = driver.findElement(By.xpath("//iframe[@name=\"globalSqa\"]"));
        driver.switchTo().frame(frame);
    }
}
