package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown
{
    WebDriver driver = null;

    @BeforeMethod
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.home")+"/IdeaProjects/ESPN/Generic/drivers/chromedriverLinux");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
    }

    @Test
    public void dropDownTest() throws InterruptedException
    {
        //List<WebElement> allMonth = driver.findElements(By.xpath("//select[@id = 'month']/option"));
        Select allDep = new Select(driver.findElement(By.cssSelector("#month")));

//        for (int i = 0; i < allMonth.size(); i++ ){
//            WebElement dropDownList = allMonth.get(i);
//            String li = dropDownList.getText();
//            System.out.println(li);
//        }


        switch ("May")
        {
            case  "Jan":
                allDep.selectByVisibleText("Jan");

                break;

            case "Feb":
                allDep.selectByVisibleText("Feb");
                break;
            case  "Mar":
                allDep.selectByVisibleText("Mar");
                break;

            case "Apr":
                allDep.selectByVisibleText("Apr");
                break;
            case  "May":
                allDep.selectByVisibleText("May");
                break;

            case "Jun":
                allDep.selectByVisibleText("Jun");
                break;
                default:
                    System.out.println("You put invalid month string.");


        }



//        Select allDep = new Select(driver.findElement(By.cssSelector("#month")));
//
//        allDep.selectByVisibleText("Nov");
//
//        Thread.sleep(5000);




    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
