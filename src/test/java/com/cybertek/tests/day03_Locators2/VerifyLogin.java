package com.cybertek.tests.day03_Locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyLogin {
    /*
    1.go to login page :practice.cybertekschool.com/login
    2.enter username : tomsmith
    3.enter password: SuperSecretPassword
    4.click login button
    5.Verify the Welcome message" Welcome to the secure Area. When you are done click logout below
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
       driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement((By.id("wooden_spoon"))).click();

        //locating the welcome message with tagname
        WebElement welcomeMessage=driver.findElement(By.tagName("h4"));
        //Verify the welcome message
        //expected vs actual
        String expectedMessage="Welcome to the Secure Area. When you are done click logout below.";
        //getText() ->convert WebElement to String
        String actualMessage=welcomeMessage.getText();

        if(actualMessage.equals((expectedMessage))){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }
        driver.close();
    }
}
