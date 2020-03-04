package com.cybertek.tests.day01_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTitle {
    public static void main(String[] args) {
        /*
        1.Go to cybertek practice web site :http://practice.cybertekschool.com/
        2.verify Title  expected Title:Practice

        Actual Title?
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        String expectedTitle="Practice";
        String actualTitle=driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Pass");
        }else{
            System.out.println("False");
            System.out.println("I expected "+expectedTitle);
            System.out.println("Actual title is "+actualTitle);
        }

        driver.close();




    }
}
