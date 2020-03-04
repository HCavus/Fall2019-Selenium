package com.cybertek.tests.day02_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    /*
    User story: As a user, I should be able to login VyTrack app
    test case1:login successfully

    1. go to VyTrack login page
    2. write username data:storemanager52
    3. write password data:UserUser123
    4.click login button
    5. Verify that user is on home page

    test case2: login invalid credential
    1. goto login page
    2. write invalid username
    3.write invalid password
    4. click login button
    5.Verify that the user see error message"Invalid username or password " on loginpage

     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://app.vytrack.com/user/login");
        driver.manage().window().maximize();
       driver.findElement(By.id("prependedInput")).sendKeys("storemanager52");
       driver.findElement((By.id("prependedInput2"))).sendKeys("UserUser123");

       WebElement loginButton=driver.findElement(By.id("_submit"));
       loginButton.click();

       //login button can be found and clicked directly
        //driver.findElement(By.id("_submit")).click();
       /*
       Verify that you are in the homepage
        */
        String expectedURL="https://app.vytrack.com/";
        String actualURL=driver.getCurrentUrl();
        if(expectedURL.equals(actualURL)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
            System.out.println("I expected "+expectedURL);
            System.out.println("Actual URL is "+actualURL);
        }
driver.close();
    }
}
