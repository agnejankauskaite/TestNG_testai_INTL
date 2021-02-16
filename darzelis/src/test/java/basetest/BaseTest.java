package basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeClass
    public static void setUp() {
    	System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://akademijait.vtmc.lt:8181/darzelis/");
    }

//    @BeforeMethod
//    public void openLoginPage() {
//        driver.get("http://akademijait.vtmc.lt:8181/darzelis/");
//    }

    @AfterClass
    public static void closeBrowser() {
        driver.manage().deleteAllCookies();
//        driver.close();
    }
}