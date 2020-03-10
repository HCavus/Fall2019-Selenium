package com.cybertek.tests.day05_moreXpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathDemo {
    public static void main(String[] args) {
        //get Chrome of firefox
        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        //open browser
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

//represent an element from page
        //where the elements come from?
        //from the findElements methods
        //how findElements find element?
        //using locators
        WebElement button1=driver.findElement(By.xpath("//button[@onclick='button1()']"));
        //start interacting with the element
        String txt=button1.getText();
        System.out.println(txt);

        WebElement button2=driver.findElement(By.xpath("//h3/following-sibling::button[2]"));
        System.out.println(button2.getText());

        System.out.println(driver.findElement(By.xpath("//button[3]")).getText());

        WebElement button4=driver.findElement(By.xpath("//div/button/[4]"));
        System.out.println(button4.getText());

        WebElement button5=driver.findElement(By.xpath("//button[.='Button 5']"));
        System.out.println(button5.getText());

        WebElement button6=driver.findElement(By.xpath("//button[@id='disappearing_button']"));
        ///getAttribute("value") --> method to get text from element, used with
        //get text of the element
        System.out.println(button6.getAttribute("innerHTML"));
        //if none of the works use outerHTML
        System.out.println(button6.getAttribute("outerHTML"));

    }
}
