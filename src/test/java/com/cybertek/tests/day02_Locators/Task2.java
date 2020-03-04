package com.cybertek.tests.day02_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    /*
    2. Go to Bookit login page
https://cybertek-reservation-qa.herokuapp.com/sign-in
2. Verify that URL contains “cybertek-reservation”
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://cybertek-reservation-qa.herokuapp.com/sign-in");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        String expectedURL="https://cybertek-reservation-qa.herokuapp.com/sign-in";

        if(expectedURL.contains("cybertek-reservation")){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
            System.out.println(expectedURL+ " URL does not contain 'cybertek-reservation' ");

        }
        driver.close();
    }
}
