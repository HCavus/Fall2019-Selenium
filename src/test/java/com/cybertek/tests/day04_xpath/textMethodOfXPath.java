package com.cybertek.tests.day04_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class textMethodOfXPath {
    public static void main(String[] args) {
        /*
        go to http://practice.cybertekschool.com/context_menu
        verify Context menu is on the page
         */
        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/context_menu");
        WebElement contextMessage=driver.findElement(By.xpath("//h3[text()='Context Menu']"));
        String expected="Context Menu";
        String actual=contextMessage.getText();
        if(expected.equals(actual)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }
        driver.close();
    }
}
