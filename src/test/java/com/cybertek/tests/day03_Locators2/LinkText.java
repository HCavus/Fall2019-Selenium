package com.cybertek.tests.day03_Locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkText {
    public static void main(String[] args) throws InterruptedException {
        //Locator  --> Linktext
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        WebElement example3 = driver.findElement(By.linkText("Example 3: Element on page that" +
                " is hidden and become visible after 5 seconds"));
        String text = example3.getText();
        System.out.println(text);

        //linkText vs PartialLinkText
        //I want to locate example3 with only part of it.

        WebElement example3_2 = driver.findElement(By.partialLinkText("Example 3:"));
        String text2 = example3_2.getText();
        System.out.println(text2);
//locate Cybertek School
        WebElement exmp = driver.findElement((By.linkText("Cybertek School")));
        //I cannot print the exmp because it is a webElement
        //In order to print I need getText() method
        String text3 = exmp.getText();
        System.out.println(text3);
        //locate Home
        WebElement home = driver.findElement((By.linkText("Home")));
        String text4 = home.getText();
        System.out.println(text4);
    }
}