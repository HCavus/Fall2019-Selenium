package com.cybertek.tests.day04_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickvsSubmit {
    public static void main(String[] args) throws InterruptedException {
        /*
        Click() vs Submit()

        task:
        go to forgot password web page
        enter any email
        click "retrieve password " button
        verify the URL is:
        http://practice.cybertekschool.com/email_sent
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().fullscreen();
        Thread.sleep(3000);

        //locate the emailbox first
        //enter any email
        WebElement emailBox=driver.findElement(By.name("email"));
        //enter email
        emailBox.sendKeys("abc@gmaail.com");

        //locate the button first
        //click "retrieve password" button
        WebElement submitButton=driver.findElement(By.id("form_submit"));
        //since the value of id contains submit keyword, better to use submit()
        submitButton.submit();

        String expectedURL="http://practice.cybertekschool.com/email_sent";
        String actualURL=driver.getCurrentUrl();

        if(expectedURL.equals(actualURL)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
            System.out.println("I expect "+expectedURL);
            System.out.println(("Actual Expect is "+actualURL));
        }
    }
}
