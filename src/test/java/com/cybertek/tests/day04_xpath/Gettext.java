package com.cybertek.tests.day04_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gettext {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //go to forgot password page
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();
        /*
        go to forgot page
        enter the email
        verify the text is "Your email's been sent"
         */
        WebElement emailBox=driver.findElement(By.name("email"));
        emailBox.sendKeys("abc@gmaail.com");

        //locate the button first
        //click "retrieve password" button
        WebElement submitButton=driver.findElement(By.id("form_submit"));
        submitButton.submit();

        //locate the text
        String expectedText="Your e-mail's been sent!";
        WebElement message=driver.findElement((By.name("confirmation_message")));

        //getText()
        String  actualText=message.getText();
        if(expectedText.equals(actualText)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }

        driver.close();
    }
}
