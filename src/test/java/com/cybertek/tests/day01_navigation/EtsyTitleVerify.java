package com.cybertek.tests.day01_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsyTitleVerify {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.etsy.com/");
        driver.manage().window().maximize();
        String expectedResult1="Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        String actualResult1=driver.getTitle();

        if(expectedResult1.equals(actualResult1)){
            System.out.println("Pass");
        }else{
            System.out.println("False");
            System.out.println("I expected "+expectedResult1);
            System.out.println("Actual title is "+actualResult1);
        }
        driver.close();
    }
}
