package testng;

import org.testng.annotations.Test;

public class PriorityOrder {

    // Default priority value is 0.
    // If 2 test cases have same priority, then test case execute in abhabetical order
    @Test
    public void testX() {
        System.out.println(" I am test X");
    }
    @Test
    public void testZ() {
        System.out.println(" I am test Z");
    }
    @Test(priority = 1)
    public void testY() {
        System.out.println(" I am test Y");
    }
    @Test(priority = 1)
    public void testA() {
        System.out.println(" I am test A");
    }
}

// x z a y