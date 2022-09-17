package selenium.assrt;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {
    @Test
    public void addTest() {
        int sum = 2 + 3;
        Assert.assertEquals(sum,5);
    }
    @Test
    public void addTest1() {
        int sum = 2 + 3;
        Assert.assertNotEquals(sum,6);
    }
    @Test(priority = 1)
    public void addTest2() {
        int sum = 2 + 3;
        Assert.assertEquals(sum,6);
    }
    @Test(priority = 2)
    public void addTest3() {
        int sum = 2 + 3;
        Assert.assertNotEquals(sum,5);
    }

}
