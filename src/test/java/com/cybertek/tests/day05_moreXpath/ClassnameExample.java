package com.cybertek.tests.day05_moreXpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassnameExample {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");

        WebElement link=driver.findElement(By.className("nav-link"));
        System.out.println(link.getText());

        //class name does not work if the value of the class has spaces
       // WebElement loginBtn=driver.findElement(By.className("btn btn-primary"));  //there is space
       // loginBtn.click();
    }
}
