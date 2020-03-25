package com.cybertek.tests.day12_pops_tabs_alerts_iframes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class TabsAndWindowsExample {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver= WebDriverFactory.getDriver("chrome");

    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/windows");
        WebElement link=driver.findElement(By.linkText("Click Here"));
        link.click();

        //get all avaiable tabs
        Set<String> windowHandles=driver.getWindowHandles();

        //print all the windows handle
        for(String windowHandle:windowHandles){
            System.out.println(windowHandle);
        }
        //get the id of current window /tab
        String currentWindow=driver.getWindowHandle();
        System.out.println("currentWindow = " + currentWindow);

        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.tagName("h3")).getText());
    }
}
