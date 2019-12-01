//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//import org.junit.Test;
//import org.junit.jupiter.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TraditionalTestsV2 {
    @Test
    public void VS2LoginTest() throws InterruptedException {
        WebDriver driver;
        String baseURL;

        //Set driver location
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\RH868FT\\Desktop\\ApplitoolsHackathonFiles\\chromedriver.exe");

        //launch chrome
        driver = new ChromeDriver();

        //establish and navigate to url to test
        baseURL = "https://demo.applitools.com/hackathonV2.html";
        driver.get(baseURL);


        //--USERNAME--//
        //assert label exists
        assertEquals("Username", driver.findElement(By.xpath("(//label)[1]")).getText());

        //assert field exists
        assertTrue((driver.findElement(By.id("username")) instanceof WebElement));

        //assert placeholder exists
        assertEquals("John Smith",
                driver.findElement(By.id("username")).getAttribute("placeholder"));


        //--PASSWORD--//
        //assert label exists
        assertEquals("Pwd", driver.findElement(By.xpath("(//label)[2]")).getText());

        //assert field exists
        assertTrue((driver.findElement(By.id("password")) instanceof WebElement));

        //assert placeholder exists
        assertEquals("ABC$*1@",
                driver.findElement(By.id("password")).getAttribute("placeholder"));


        //--SIGN-IN--//
        //assert button exists
        assertTrue((driver.findElement(By.id("log-in")) instanceof WebElement));

        //assert label exists
        assertEquals("Log In", driver.findElement(By.id("log-in")).getText());

        //--REMEMBER ME--//
        //assert fields exists
        assertTrue((driver.findElement(By.xpath("//input[@class='form-check-input']")) instanceof WebElement));

        //assert labels exists
        assertEquals("Remember Me", driver.findElement(By.xpath("(//label)[3]")).getText());


        //--SOCIAL MEDIA BUTTONS--//
        //assert twitter button exists
        assertTrue(driver.findElement(By.xpath("/html/body/div/div/form/div[3]/div[2]/span[1]/img")) instanceof WebElement);

        //assert facebook button exists
        assertTrue((driver.findElement(By.xpath("/html/body/div/div/form/div[3]/div[2]/span[2]/img")) instanceof WebElement));


        ////DATA-DRIVEN TESTS
        ////a. No password or username
        //click on login-button
        driver.findElement(By.id("log-in")).click();

        //wait
        Thread.sleep(2000);

        //assert error message
        assertEquals("Please enter both username and password",
                driver.findElement(By.xpath("/html/body/div/div/div[3]")).getText());

        ////b. No Password
        // map username
        driver.findElement(By.id("username")).sendKeys("tester");

        //click on login-button
        driver.findElement(By.id("log-in")).click();

        //wait
        Thread.sleep(2000);

        //assert error message
        assertEquals("Password must be present",
                driver.findElement(By.xpath("/html/body/div/div/div[3]")).getText());

        ////c. No Username
        //clear username field
        driver.findElement(By.id("username")).clear();

        //map password
        driver.findElement(By.id("password")).sendKeys("test123");

        //click on login-button
        driver.findElement(By.id("log-in")).click();

        //wait
        Thread.sleep(2000);

        //assert error message
        assertEquals("Username must be present",
                driver.findElement(By.xpath("/html/body/div/div/div[3]")).getText());

        ////d. Both password and user name
        //clear password field
        driver.findElement(By.id("password")).clear();

        //map username
        driver.findElement(By.id("username")).sendKeys("testing");

        //map password
        driver.findElement(By.id("password")).sendKeys("test1234");

        //click on login-button
        driver.findElement(By.id("log-in")).click();

        //wait
        Thread.sleep(2000);

        //assert on new page
        assertEquals("Financial Overview",
                driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/h6[2]")).getText());


        //END OF TEST SPECS//
        System.out.println("Session ending...");

        //wait before closing browser
        Thread.sleep(2000);

        //close the browser
        driver.close();
    }
}
