package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class InterviewQuest {
    WebDriver driver = null;

    @BeforeMethod
    public void setUp()
    {
        //Location of web driver;
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.home")+"/IdeaProjects/ESPN/Generic/drivers/chromedriverLinux");
        //Declare the browser driver;
        driver = new ChromeDriver();
        //Declare the url;
        driver.navigate().to("https://www.amazon.com/");
        //Maximize the window
        driver.manage().window().maximize();
        //Declare implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Declare page load wait.
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
    }

    @Test
    public void testSearch()
    {
        //locate the elements
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Book");
        //perform the activity
        driver.findElement(By.cssSelector("#nav-search > form > div.nav-right > div > input")).click();
    }

    //Positive Test
    @Test
    public void login()throws InterruptedException
    {
        Actions actions = new Actions(driver);
        WebElement accList = driver.findElement(By.cssSelector("#nav-link-accountList > span.nav-line-1"));
        WebElement signIn = driver.findElement(By.cssSelector("#nav-link-accountList > span.nav-line-1"));

        actions.moveToElement(accList).moveToElement(signIn).click().build().perform();

        driver.findElement(By.cssSelector("#ap_email")).sendKeys("ikr22015@gmail.com");
        driver.findElement(By.xpath("//input[@id=\"continue\"]")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("#ap_password")).sendKeys("iJrS2085");
        driver.findElement(By.cssSelector("#signInSubmit")).submit();
        Thread.sleep(3000);


        String text = driver.findElement(By.cssSelector("#nav-link-accountList > span.nav-line-1")).getText();

        Assert.assertEquals("Hello, Imran",text);
    }

    //Negative test
    @Test
    public void logInFail() throws InterruptedException
    {
        Actions actions = new Actions(driver);
        WebElement accList = driver.findElement(By.cssSelector("#nav-link-accountList > span.nav-line-1"));
        WebElement signIn = driver.findElement(By.cssSelector("#nav-link-accountList > span.nav-line-1"));

        actions.moveToElement(accList).moveToElement(signIn).click().build().perform();

        driver.findElement(By.cssSelector("#ap_email")).sendKeys("ikr22015@gmail.com");
        driver.findElement(By.xpath("//input[@id=\"continue\"]")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("#ap_password")).sendKeys("iJrS2084545");
        driver.findElement(By.cssSelector("#signInSubmit")).submit();
        Thread.sleep(3000);

        WebElement errPasswordAralt = driver.findElement(By.cssSelector("#auth-error-message-box > div"));

        Assert.assertEquals(errPasswordAralt,errPasswordAralt);
    }

    @AfterMethod
    public void tearDown()
    {
        //Quite the browser.
        driver.quit();
    }
}
