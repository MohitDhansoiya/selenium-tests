package selenium.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBook {
    public static void main(String[] args){
//        String project = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Thic PC\\IdeaProjects\\selenium-java-maven\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
    }
}
