package com.cybertek.tests.day02_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElement {
    public static void main(String[] args) {
        //Locator 1. ID
        //go to cybertek okta login page
        //write email to the text box
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://cybertekschool.okta.com/");

        // find the text box first--> findElement()  from WebDriver
        WebElement emailBox=driver.findElement(By.id("okta-signin-username"));
        emailBox.sendKeys("halimeecavus@gmail.com");
        WebElement passwordBox=driver.findElement((By.id("okta-signin-password")));
        passwordBox.sendKeys(("52"));
    }
}
