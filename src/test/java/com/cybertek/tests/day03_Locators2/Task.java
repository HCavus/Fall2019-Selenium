package com.cybertek.tests.day03_Locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {
    /*
    locators--> id, name, classname,
    If class attributes value has a space or spaces,
    driver can not locate the element

    Task:
    1.Go to amazon  https://www.amazon.com/
    2.Go to Ebay   https://www.ebay.com/
    3.Enter a search term
    4.Click on search button
    5.Verify title contains search term
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.navigate().to("https://www.ebay.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        //Keys.ENTER->clicks the enter button
       driver.findElement(By.id("gh-ac")).sendKeys("shoes"+ Keys.ENTER);
    //driver.findElement((By.id("gh-btn"))).click();
    String expectedTitle="search | eBay";
    String actualTitle=driver.getTitle();
    if(actualTitle.contains("shoes")){
        System.out.println("Pass");
    }else {
        System.out.println("Fail");
        System.out.println("I expect "+expectedTitle);
        System.out.println("Actual Title "+actualTitle);
    }
driver.close();

    }
}
