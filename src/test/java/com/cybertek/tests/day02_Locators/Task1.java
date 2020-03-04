package com.cybertek.tests.day02_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    /*
        1. Go to Bookit login page
            https://cybertek-reservation-qa.herokuapp.com/sign-in
        2. Verify the title of the page
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get(" https://cybertek-reservation-qa.herokuapp.com/sign-in");
        driver.manage().window().fullscreen();
        Thread.sleep(3000);
        String expectedTitle="bookit";
        String actualTitle=driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
            System.out.println("Expected Title:"+expectedTitle);
            System.out.println("Actual Title:"+actualTitle);
        }
        driver.close();
    }
}
