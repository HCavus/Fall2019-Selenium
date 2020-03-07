package com.cybertek.tests.day04_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XPath {
    public static void main(String[] args) {
        //go to practice login page
        //locate username box with absolute path
        //locate username box with relative path
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //absolute xpath
        WebElement userName=driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/div/div/input"));
        userName.sendKeys("tomsmith");

        //relative xpath
        driver.findElement(By.xpath("//input[@ name='username']"));
        driver.findElement(By.xpath("//*[@ name=\"username\"]"));
        driver.findElement(By.xpath("//*[@id=\"login\"]/div[1]/div/input"));

    }
}
