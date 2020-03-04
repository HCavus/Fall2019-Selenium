package com.cybertek.tests.day01_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyURLOfPracticeWeb {
    public static void main(String[] args) {
        /*
        1.go to cybertek practice web site
        http://practice.cybertekschool.com/
        2.verify the url
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().fullscreen();
        String expectedURL="http://practice.cybertekschool.com/";
        String actualURL= driver.getCurrentUrl();
        if(expectedURL.equals(actualURL)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
            System.out.println("I expect "+expectedURL);
            System.out.println("Actual URL is "+actualURL);
        }
    }
}
