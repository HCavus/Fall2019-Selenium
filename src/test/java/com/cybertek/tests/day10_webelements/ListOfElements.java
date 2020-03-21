package com.cybertek.tests.day10_webelements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class ListOfElements {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    /*
    go to page radio buttons
    verify that none of the sports radio buttons are selected
     */
    @Test
    public void listOfRadioButtons() {
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //driver.findelements --> returns a LIST of element

        //if the locator does not match anything, it does not throw exception, it just return empty list
        List<WebElement> sports = driver.findElements(By.name("sport"));
        System.out.println(sports.size());  //4

        for (WebElement radiobutton : sports) {
            Assert.assertFalse(radiobutton.isSelected());
        }
    }

    /*
    go to practice website
    get all the links present in the page
    print their text
     */
    @Test
    public void getAllLinksTest() {
        driver.get("http://practice.cybertekschool.com/");
        //get all the links in a page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        for (WebElement link : links) {
            System.out.println(link.getText());
        }
    }

    /*
    go to amazon.com
    search for lysol disinfecting wipes
    print he number of results
    print the first result
    print the second result
    print he last result
     */
    @Test
    public void amazonSearch() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("paper towels" + Keys.ENTER);
        List<WebElement> list = driver.findElements(By.cssSelector("span.a-size-base-plus"));
        Thread.sleep(2000);
        System.out.println("Number of results: " + list.size());
        System.out.println("First result: " + list.get(0).getText());
        System.out.println("Second result: " + list.get(1).getText());
        System.out.println("Last result: " + list.get(list.size() - 1).getText());
    }

    /*
    go to http://practice.cybertekschool.com/radio_buttons
    verify that all sports checkboxes are NOT checked by default
    randomly check any sport
    verify that sport is clicked
    verify that all other sports are not clicked
    repeat the last step for 5 times

     */
    @Test
    public void sportsCheckedTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        List<WebElement> sports = driver.findElements(By.name("sport"));
        System.out.println("verifying none of them selected by default");

        //checking all the sport checkboxes are not checked
        for (WebElement sport : sports) {
            Assert.assertFalse(sport.isSelected());

        }
        Thread.sleep(3000);
        //randomly clicking and verifying
        Random item = new Random();
        for (int i = 0; i < 5; i++) {
            Thread.sleep(2000);
            int num = item.nextInt(4);
            sports.get(num).click();
            System.out.println("Selecting button number:" + (num + 1));
            for (int j = 0; j < sports.size(); j++) {
                if (j == num) {
                    Assert.assertTrue(sports.get(num).isSelected());
                } else {
                    Assert.assertTrue(sports.get(num).isSelected());
                }
            }


        }
    }
}
