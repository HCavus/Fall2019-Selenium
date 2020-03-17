package com.cybertek.tests.day07_review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTestWithText {
    /*
     1.open browser
    2.go to amazon
    3.search for 'selenium cookbook'
    4.verify that there is result with text'selenium Testing Tools Cookbook-Second Edition'
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");


        WebElement searchInput=driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/form/div[3]/div/input"));
        //OPTION 1.enter search term and hit ENTER button
        searchInput.sendKeys("selenium cookbook"+ Keys.ENTER);


        WebElement result=driver.findElement(By.xpath("//span[.='Selenium Testing Tools Cookbook - Second Edition']"));
        System.out.println(result.getText());
        Thread.sleep(2000);
        driver.close();
    }
}
