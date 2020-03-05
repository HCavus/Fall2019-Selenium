package com.cybertek.tests.day03_Locators2;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyErrorMessage {
    /*/
    1. go to login page:http://practice.cybertekschool.com/login
    2. enter invalid username
    3. enter invalid password
    4.verify the error message ' Your username is invalid!'
     */
    //tester will gather test data in excel sheet
    //1.generate from dummy data website
    //java faker

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");

        Thread.sleep(3000);

        Faker faker=new Faker();
        String username=faker.name().fullName();
        String password=faker.app().author();

        driver.findElement(By.name("username")).sendKeys(username);
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement((By.id("wooden_spoon"))).click();
    }
}
