package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionScript
{
    @Test
    public void test1()
    {
        System.out.println("Test 1 starts");
        Assert.assertEquals(12,123);
        System.out.println("Test 1 completed");
    }

    @Test
    public void test2()
    {
        System.out.println("Test 2 starts.");
        Assert.assertEquals(100,100,"The numbers do not match. pls check the numbers again");
        System.out.println("Test 2 competed");
    }

    @Test
    public void test3()
    {
        System.out.println("Test 3 starts.");
        Assert.assertEquals(500,100,"The numbers do not match. pls check the numbers again");
        System.out.println("Test 3 competed");
    }
}
