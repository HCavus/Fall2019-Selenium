package com.cybertek.tests.day01_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations {
    public static void main(String[] args) throws InterruptedException {
        /*
        Navigations:
        driver.navigate().to("URL");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //go to practice --> google-->back to practice -->forward to google

        String practiceWebURL="http://practice.cybertekschool.com/";
        //go to practice
        driver.get(practiceWebURL);

        //I want to see the full window
        //driver.manage().window().fullscreen();
        driver.manage().window().maximize();

        Thread.sleep(3000);
        //go to google
        String gglURL="https://www.google.com";
        driver.navigate().to(gglURL);
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        driver.navigate().refresh();
        //close drive
        driver.close(); //closes the last website
       // driver.quit(); //close down  all the windows in a browser
    }
}
