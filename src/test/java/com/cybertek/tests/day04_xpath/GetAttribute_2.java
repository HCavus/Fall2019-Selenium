package com.cybertek.tests.day04_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute_2 {
    /*/
    go to http://practice.cybertekschool.com/dynamic_loading
    locate Example 1: Element on page that is hidden and become visible after trigger
    print out Attributes value
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

//TODO link text
        driver.get(" http://practice.cybertekschool.com/dynamic_loading");
        driver.manage().window().maximize();

        WebElement example1=driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
        System.out.println(example1.getAttribute("href"));

        //TODO partialLinktext
        WebElement example2=driver.findElement(By.partialLinkText("Example 2:"));
        System.out.println(example2.getText());

    }
}
