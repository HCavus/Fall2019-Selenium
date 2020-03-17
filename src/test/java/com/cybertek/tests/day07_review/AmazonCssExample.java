package com.cybertek.tests.day07_review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonCssExample {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");
        WebElement todaysDeal=driver.findElement(By.cssSelector("a[tabindex='47']"));
        todaysDeal.click();

        String expected="Today's Deals";
        WebElement tophheader=driver.findElement(By.cssSelector(".nav-a-content"));
        String actual=tophheader.getText();
        System.out.println(actual);
        if(expected.equals(actual)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected: "+expected);
            System.out.println("Actual: "+actual);
        }
        WebElement buttomHeader=driver.findElement(By.cssSelector("h1>div:nth-of-type(1)"));
        System.out.println(buttomHeader.getText());
        if(expected.equals(buttomHeader.getText())){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected: "+expected);
            System.out.println("Actual: "+buttomHeader.getText());
        }
        driver.close();
    }
};
