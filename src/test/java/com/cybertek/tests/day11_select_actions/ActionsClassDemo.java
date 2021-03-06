package com.cybertek.tests.day11_select_actions;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ActionsClassDemo {
    WebDriver driver;
  Actions actions;

    @BeforeMethod
    public void beforeMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        actions=new Actions(driver);
    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
    @Test
    public void hoverTest() throws InterruptedException {
      driver.get("http://practice.cybertekschool.com/hovers");
        Thread.sleep(3000);
        WebElement target=driver.findElement(By.tagName("img"));

        //moveToElement --> moves the mouse on top of the given webelement
        actions.moveToElement(target).perform();
        Thread.sleep(3000);
    }
    @Test
    public void hover2(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        WebElement enabled=driver.findElement(By.id("ui-id-3"));
        WebElement downloads=driver.findElement(By.id("ui-id-4"));
        WebElement pdf=driver.findElement(By.id("ui-id-5"));
        //move the mouse to enabled, wait, move the mouse to downloads, wait, move the mouse to pdf, and perform
        actions.moveToElement(enabled).pause(4000).moveToElement(downloads).pause(4000).click(pdf).build().perform();

    }
    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index" );

          WebElement money=driver.findElement(By.id("draggable"));
        WebElement bank=driver.findElement(By.id("droptarget"));
        Thread.sleep(3000);

        //scroll down
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        // actions.sendKeys(Keys.ARROW_DOWN).perform();

        actions.dragAndDrop(money,bank).perform();
        Thread.sleep(3000);
    }
    /*/
    Task:
    do drag and drop by chaining actions
    move mouse to source/money
    mouse down
    move to mouse to bank
    mouse up
     */
@Test
    public void DragAndDrop2() throws InterruptedException {
    driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index" );
    WebElement money=driver.findElement(By.id("draggable"));
    WebElement bank=driver.findElement(By.id("droptarget"));
    Thread.sleep(3000);
    actions.moveToElement(money).clickAndHold().moveToElement(bank).release().build().perform();
    Thread.sleep(3000);

}
}
