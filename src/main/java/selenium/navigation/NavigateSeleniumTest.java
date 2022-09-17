package selenium.navigation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigateSeleniumTest {

    @Test
    public void navigate1(){
        String name = "Mohit";
        Assert.assertEquals(name,"Mohit");
    }

    public void navigate2(){
        String name = "Mohit";
        Assert.assertEquals(name,"Anuj");
    }
}
