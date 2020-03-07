package com.cybertek.tests.day04_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute {
    public static void main(String[] args) {
        /*/
        go to forgot password page
        locate retrieve password button
        print out the submit value.
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //go to forgot password page
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();
        WebElement retrievePassWordButton=driver.findElement(By.id("form_submit"));

        //<button id="form_submit" class="radius" type="submit">
        // <i class="icon-2x icon-signin">Retrieve password</i></button>
        System.out.println(retrievePassWordButton.getAttribute("type"));
        System.out.println(retrievePassWordButton.getAttribute("class"));
        System.out.println(retrievePassWordButton.getAttribute("id"));

        driver.close();
    }
}
