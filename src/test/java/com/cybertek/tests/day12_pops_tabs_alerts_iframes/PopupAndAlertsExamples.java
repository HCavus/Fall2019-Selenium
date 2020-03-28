package com.cybertek.tests.day12_pops_tabs_alerts_iframes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class PopupAndAlertsExamples {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver= WebDriverFactory.getDriver("chrome");

    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
    @Test
    public void htmlPopup() throws InterruptedException {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        driver.findElement(By.xpath("//span[text()='Destroy the World']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[.='No']")).click();
        Thread.sleep(3000);
    }
    @Test
    public void jsAlerts() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement button1=driver.findElement(By.xpath("//button[1]"));
        button1.click();
        Thread.sleep(3000);

        Alert alert=driver.switchTo().alert();
        alert.accept();
        Thread.sleep(3000);
    }
    @Test
    public void jsAlertsCancel() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement button2=driver.findElement(By.xpath("//button[2]"));
        button2.click();
        Thread.sleep(3000);

        Alert alert=driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(3000);
    }
    @Test
    public void jssendKeys() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement button3=driver.findElement(By.xpath("//button[3]"));
       // button3.click();
        Alert alert=null;
        try{
            alert=driver.switchTo().alert();
            alert.sendKeys("Halime Cavus");
            alert.accept();
        }catch(NoAlertPresentException e){
            e.printStackTrace();
        }

    }
}
