package com.cybertek.tests.day10_webelements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtons {
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
    verify that blue is selected
    red is not selected
     */
    @Test
    public void test1(){

        WebElement blue=driver.findElement(By.id("blue"));
        //isSelected -->returns true if element is selected
        System.out.println(blue.isSelected());
        //verifying the radio button is selected
        Assert.assertTrue(blue.isSelected());

        WebElement red=driver.findElement(By.id("red"));
        //print re is not selected
        System.out.println(red.isSelected()); //true
        //verify the statement  is false. if it false, it passes. If true it fails.
        Assert.assertFalse(red.isSelected()); //false
    }
      /*
    go to http://practice.cybertekschool.com/radio_buttons
    click on red
    verify that blue is not selected
red is selected
     */
      @Test
    public void test2(){
          WebElement red=driver.findElement(By.id("red"));
          WebElement blue=driver.findElement(By.id("blue"));
          red.click();
          Assert.assertFalse(blue.isSelected()); //true
          Assert.assertTrue(red.isSelected()); //true
      }
}
