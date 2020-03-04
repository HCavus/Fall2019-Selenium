package com.cybertek.tests.day01_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsyPractice {
    public static void main(String[] args) throws InterruptedException {
        /*
        1. go to google website
        2. save the title in a string variable
        3.go to etsy
        4.save the Etsy title in a String
        5. Navigate back to previous page
        6. Verify the title is same as step 2
        7.Navigate forward to previous page
        8.Verify the title is same as step 4

         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //1. go to google
        driver.get("https://www.google.com");
        //full screen
        driver.manage().window().maximize();
        String expectedTitle = "Google";

        driver.navigate().to("https://www.etsy.com/");


        driver.manage().window().maximize();
        String etsyExpectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";

        driver.navigate().back();
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Pass");
            System.out.println(expectedTitle + " MATCHES " + actualTitle);

        } else {
            System.out.println("fail");
            System.out.println(expectedTitle + " DOES NOT MATCH " + actualTitle);
        }

        driver.navigate().forward();
        String etsyActualTitle = driver.getTitle();
        if (etsyExpectedTitle.equals(etsyActualTitle)) {
            System.out.println("Pass");
            System.out.println(etsyExpectedTitle + " MATCHES " + etsyActualTitle);

        } else {
            System.out.println("Fail");
            System.out.println(etsyExpectedTitle + " DOES NOT MATCH" + etsyActualTitle);
        }
        driver.close();
    }
}
