package com.cybertek.tests.day10_webelements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DisabledAndDisplayed {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        Thread.sleep(3000);
    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    /*
    go to http://practice.cybertekschool.com/radio_buttons
    verify green is disabled
    verify black is enabled
     */

    @Test
    public void disabledTest(){
        WebElement green=driver.findElement(By.id("green"));
        WebElement black=driver.findElement(By.id("black"));

        //isEnabled --> returns true if the element is enabled, active
        System.out.println("Is green enabled: "+green.isEnabled()); //false
        System.out.println("Is black enabled: "+black.isEnabled()); //true
        Assert.assertFalse(green.isEnabled());
        Assert.assertTrue(black.isEnabled());

    }
    @Test
    public void disabledTestWithAttribute() {
        WebElement green = driver.findElement(By.id("green"));
        WebElement black = driver.findElement(By.id("black"));

        System.out.println("Black : " + black.getAttribute("disabled")); //null
        System.out.println("Green : " + green.getAttribute("disabled"));  //true

        //verify that certain value is equal to null.verify element is enabled
        Assert.assertEquals(black.getAttribute("disabled"), null); //true
        //verify that value of black.getAttribute("disabled") is NULL
        Assert.assertNull(black.getAttribute("disabled")); //true

        //verify that certain value is equal to TRUE.verify element is DISABLED.
        Assert.assertEquals(green.getAttribute("disabled"), "true"); //true
        Assert.assertTrue(Boolean.parseBoolean(green.getAttribute("disabled"))); //true
    }
        @Test
        public void testElementVisible() throws InterruptedException {
            driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
            WebElement username=driver.findElement(By.id("username"));
            WebElement start=driver.findElement(By.tagName("button"));
            //verify that username is not visible
            //isDisplayed -->returns true if element we found in HTML is visible on page.
            System.out.println("username is visible: "+username.isDisplayed()); //false
            Assert.assertFalse(username.isDisplayed());

            System.out.println("click on start");
            start.click();
            Thread.sleep(7000);
            System.out.println("username is visible: "+username.isDisplayed()); //true
            Assert.assertTrue(username.isDisplayed());


        }
    }

