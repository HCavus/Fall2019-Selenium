package com.cybertek.tests.day01_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyURL {


    public static void main(String[] args) {
        /*
        1.go to Etsy : https://www.etsy.com/
        2.verify URL
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.etsy.com/");
        driver.manage().window().maximize();
        //for verify title -->getTitle();
        //for verify URL -->
        String expectedURL="https://www.etsy.com/";
        String actualURL=driver.getCurrentUrl();
        if(expectedURL.equals((actualURL))){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
            System.out.println("I expected "+expectedURL);
            System.out.println("Actual URL is "+actualURL);
        }
        driver.close();
    }
}
