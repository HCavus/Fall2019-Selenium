package com.cybertek.tests.day08_review_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VytrackShortcut {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://app.vytrack.com/user/login");
        Thread.sleep(2000);
        WebElement usernameBox=driver.findElement(By.id("prependedInput"));
        usernameBox.sendKeys("salesmanager101");
        Thread.sleep(2000);
        WebElement passwordBox=driver.findElement(By.id("prependedInput2"));
        passwordBox.sendKeys("UserUser123");
        passwordBox.submit();
        Thread.sleep(2000);
        String expectedTitle="Dashboard";
        String actualTitle=driver.getTitle();

        verifyStartsWith(expectedTitle,actualTitle);

        WebElement shortcutIcon=driver.findElement(By.cssSelector("a[title='Shortcuts']"));
        shortcutIcon.click();

        WebElement allLinks=driver.findElement(By.linkText("See full list"));
        allLinks.click();
        Thread.sleep(3000);
        WebElement opportunities=driver.findElement(By.linkText("Opportunities"));
        opportunities.click();
        Thread.sleep(3000);
       verifyStartsWith("Open Opportunities",driver.getTitle());

       WebElement vehicleServiceLog=driver.findElement(By.linkText("Vehicle Services Logs"));
       vehicleServiceLog.click();
       Thread.sleep(3000);
       WebElement errorMessage=driver.findElement(By.cssSelector(".message"));
       verifyStartsWith("You do not have permission to perform this action.",errorMessage.getText());



    }
private static void verifyStartsWith(String expectedTitle,String actualTitle){
        if(actualTitle.startsWith(expectedTitle)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
            System.out.println("expectedTitle: "+expectedTitle);
            System.out.println("actualTitle: "+actualTitle);
        }
}
}
