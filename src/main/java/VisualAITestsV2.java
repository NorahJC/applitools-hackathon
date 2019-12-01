
import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.selenium.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VisualAITestsV2 {
    private static EyesRunner runner;
    private static Eyes eyes;
    private static BatchInfo batch;
    private static WebDriver driver;

    @BeforeClass
    public static void setBatch() {
        batch = new BatchInfo("Login");
        runner = new ClassicRunner();
        eyes = new Eyes(runner);
        eyes.setApiKey("fHmn101BE104iePsXoWko0JPQiBGo10752ROpgAkM5PCF0zVg110");
        eyes.setBatch(batch);

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\RH868FT\\Desktop\\ApplitoolsHackathonFiles\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void loginNoEntries(){
        driver.get("https://demo.applitools.com/hackathon.html");
        driver.findElement(By.id("log-in")).click();
        eyes.open(driver, "Login App", "Login Page Test");
        eyes.checkWindow("Login Window");
        eyes.closeAsync();
    }
    @Test
    public void loginNoPass(){
        driver.get("https://demo.applitools.com/hackathon.html");
        driver.findElement(By.id("username")).sendKeys("Test");
        driver.findElement(By.id("log-in")).click();
        eyes.open(driver, "Login App2", "Login Page Test2");
        eyes.checkWindow("Login Window");
        eyes.closeAsync();
    }

    @Test
    public void loginNoUser(){
        driver.get("https://demo.applitools.com/hackathon.html");
        driver.findElement(By.id("password")).sendKeys("testing3");
        driver.findElement(By.id("log-in")).click();
        eyes.open(driver, "Login App3", "Login Page Test");
        eyes.checkWindow("Login Window");
        eyes.closeAsync();
    }

    @Test
    public void login(){
        driver.get("https://demo.applitools.com/hackathon.html");
        driver.findElement(By.id("username")).sendKeys("Tester");
        driver.findElement(By.id("password")).sendKeys("test123");
        driver.findElement(By.id("log-in")).click();
        eyes.open(driver, "Login App4", "Login Page Test4");
        eyes.checkWindow("Login Window");
        eyes.closeAsync();
    }

    @AfterClass
    public static void afterClass(){
        driver.quit();
        eyes.abort();
    }
}



