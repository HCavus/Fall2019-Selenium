package officeHours.day_03_23_2020;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class GoogleSearch {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com/");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    /*
    go to google.com
    move the mouse to I'm feeling lucky
    verify that button now is different
    move the mouse away
    do this many times
    When you get("I am feeling stellar" 3 times, print " Deal with it" in console and exit the program
     */
    @Test
    public void test(){
       Actions actions=new Actions(driver);
        WebElement button=driver.findElement(By.id("gbqfbb"));
        actions.pause(1000).moveToElement(button).pause(1000).build().perform();
        String notUnExpected="I'm Feeling Lucky";
        String actual=button.getAttribute("value");
        System.out.println("Actual : "+actual);
        Assert.assertNotEquals(actual,notUnExpected);

        //complete the task
    }
}
