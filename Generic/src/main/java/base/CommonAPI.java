package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class CommonAPI {
    public static WebDriver driver = null;

    @BeforeMethod
    @Parameters({"browser_name", "operating_system", "URL"})
    public void setUp(String browderName, String os, String url){
        getLocalDriver(browderName,os);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(35,TimeUnit.SECONDS);
    }

    public WebDriver getLocalDriver(String browserName, String os){
        if (browserName.equalsIgnoreCase("Chrome")){
            if (os.equalsIgnoreCase("Windows")){
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.home")+"/IdeaProjects/ESPN/Generic/drivers/chromedriver.exe");
                driver = new ChromeDriver();
            }else if (os.equalsIgnoreCase("Mac OS")){
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.home")+"/IdeaProjects/ESPN/Generic/drivers/chromedriver");
                driver = new ChromeDriver();
            }else if (os.equalsIgnoreCase("Linux")){
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.home")+"/IdeaProjects/ESPN/Generic/drivers/chromedriverLinux");
                driver = new ChromeDriver();
            }
        }else if (browserName.equalsIgnoreCase("Firefox")){
            if (os.equalsIgnoreCase("Windows")){
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.home")+"/IdeaProjects/ESPN/Generic/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
            }else if (os.equalsIgnoreCase("Mac OS")){
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.home")+"/IdeaProjects/ESPN/Generic/drivers/geckodriver");
                driver = new FirefoxDriver();
            }else if (os.equalsIgnoreCase("Linux")){
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.home")+"/IdeaProjects/ESPN/Generic/drivers/geckodriverLinux");
                driver = new FirefoxDriver();
            }
        }

        return driver;
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}