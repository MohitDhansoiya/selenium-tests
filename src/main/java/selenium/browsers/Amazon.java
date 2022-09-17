package selenium.browsers;

import com.sun.deploy.net.proxy.WFirefoxProxyConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Amazon {
    public static void main(String[]args){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\Thic PC\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.amazon.in");
    }
}
