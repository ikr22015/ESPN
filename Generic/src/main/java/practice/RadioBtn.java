package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioBtn
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
        driver.navigate().to("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm?firstname=aasdasd&lastname=asdasd&sex=Male&exp=3&profession=Manual+Tester&photo=1239981_388535274610741_487247777_n.jpg&tool=Selenium+Webdriver&continents=Asia&selenium_commands=Wait+Commands&submit=");
        //Maximize the window
        driver.manage().window().maximize();
        //Declare implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Declare page load wait.
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
    }

    @Test
    public void sexSelect()
    {
        List<WebElement> radios = driver.findElements(By.xpath("//input[@name = \"sex\"]"));

        for(int i = 0; i < radios.size(); i++)
        {
            WebElement localRadio = radios.get(i);
            String value = localRadio.getAttribute("value");

            System.out.println(value);
        }
    }

    @AfterMethod
    public void tearDown()
    {
        //Quite the browser.
        driver.quit();
    }
}
