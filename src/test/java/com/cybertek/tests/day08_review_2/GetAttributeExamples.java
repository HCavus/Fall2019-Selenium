package com.cybertek.tests.day08_review_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttributeExamples {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://ebay.com");
        //get title
        System.out.println(driver.getTitle());
        //get url
        System.out.println(driver.getCurrentUrl());
        //get page source
        System.out.println(driver.getPageSource());


        WebElement myEbayLink=driver.findElement(By.linkText("My eBay"));

        String myClass=myEbayLink.getAttribute("class");
        System.out.println(myClass);
        String href=myEbayLink.getAttribute("href");
        System.out.println(href);
        System.out.println(myEbayLink.getText());

        WebElement input=driver.findElement(By.id("gh-ac"));
        input.sendKeys("wooden spoon");

        //return the text of the element
        System.out.println(myEbayLink.getAttribute("innerHTML"));

        //get the HTML information of the element
        System.out.println(myEbayLink.getAttribute("outerHTML"));
    }
}
