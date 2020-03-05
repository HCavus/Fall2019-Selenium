package com.cybertek.tests.day03_Locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeValue {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        // I want to get the value of type attribute
        //type="text" -> getAttribute("attribute name")

        //locate username box
        WebElement usernameBox=driver.findElement(By.name("username"));

        //<input type="text" name="username">

        String valueOfType= usernameBox.getAttribute("type");
        System.out.println("Value of Type: "+valueOfType);
        //<button class="btn btn-primary" type="submit" id="wooden_spoon">Login</button>
        WebElement loginButton=driver.findElement(By.id("wooden_spoon"));
        //I want to print class attribute value
        System.out.println(loginButton.getAttribute("class"));

        //getText() vs getAttribute()

    }
}
