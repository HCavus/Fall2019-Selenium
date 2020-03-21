package com.cybertek.tests.day10_webelements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxes {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        Thread.sleep(3000);
    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void test(){
        WebElement one=driver.findElement(By.xpath("//input[1]"));
        WebElement two=driver.findElement(By.xpath("//input[2]"));
        //by default one is not checked, two is checked
        System.out.println("One is selected: "+one.isSelected()); //false
        System.out.println("Two is selected: "+two.isSelected());  //true
        Assert.assertFalse(one.isSelected());
        Assert.assertTrue(two.isSelected());

        //check the first checkbox
        //verify one is selected
        //verify two is selected
        System.out.println("Check the first box");
        one.click();
        System.out.println("One is selected: "+one.isSelected()); //true
        System.out.println("Two is selected: "+two.isSelected());  //true
        Assert.assertTrue(one.isSelected());
        Assert.assertTrue(two.isSelected());

    }
}
