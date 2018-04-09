package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Webpage
{
    WebDriver driver = null;

    @BeforeMethod
    public void setUp()
    {
        //Location of web driver;
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.home")+"/IdeaProjects/ESPN/Generic/drivers/chromedriverLinux");
        //Declare the browser driver;
        driver = new ChromeDriver();
        //Declare the url;
        driver.navigate().to("file:///home/imran/IdeaProjects/webpage/index.html?");
        //Maximize the window
        driver.manage().window().maximize();
        //Declare implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Declare page load wait.
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
    }

    @Test
    public void test1()
    {
        driver.findElement(By.cssSelector("#exampleInputEmail1")).sendKeys("Book");
    }

    @AfterMethod
    public void tearDown()
    {
        //Quite the browser.
        driver.quit();
    }
}
