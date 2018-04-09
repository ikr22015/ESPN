package practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssartDemo {
    @Test
    public void test1()
    {
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Test 1 is started.");
        softAssert.assertEquals(12,13);
        System.out.println("Test 1 is completed.");
        softAssert.assertAll();
    }
}
