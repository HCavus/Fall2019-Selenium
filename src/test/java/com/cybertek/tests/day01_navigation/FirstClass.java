package com.cybertek.tests.day01_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClass {
    public static void main(String[] args) throws InterruptedException {

        //binary the driver and browsers , this is how we set up the driver
        WebDriverManager.chromedriver().setup();
        //WebDriver object--> interface
        // I have a driver
        WebDriver driver=new ChromeDriver();
        //I want to open Google home page
        //how do you open/launch web page
        //by using get() --> url as String
       // driver.get("https://www.google.com");

        //Navigations
        //navigate().to() -> open a web page
        //driver.navigate().to("https://www.google.com");

        //get() vs navigate().to()
        //get --> wait to load the page
        //navigate().to() --> does not wait

        //navigate().back() -->
        //1.go to google
        // 2. go to cybertek practice website

        driver.get("https://www.google.com");
        Thread.sleep(3000);
        driver.navigate().to("http://practice.cybertekschool.com/");
        Thread.sleep(3000);
        driver.navigate().back();






    }
}
