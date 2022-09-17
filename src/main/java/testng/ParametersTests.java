package testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTests {

    @Test
    @Parameters({"browser"})
    public void paramsTest(String bName) {

        if (bName.equalsIgnoreCase("CHROME")) {
            System.out.println("I am Chrome browser code");
        } else if (bName.equalsIgnoreCase("FIREFOX")) {
            System.out.println("I am Firefox browser code");
        } else {
            System.out.println("I am generic  code");
        }

    }
}
