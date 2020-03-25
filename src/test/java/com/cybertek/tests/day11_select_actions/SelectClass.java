package com.cybertek.tests.day11_select_actions;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectClass {
    WebDriver driver;
    private Arrays Arraylist;

    @BeforeMethod
    public void beforeMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
    @Test
    public void getSelectedOptions(){
        //find the element that has select tag
        WebElement dropdown=driver.findElement(By.id("dropdown"));
        //create a select class using the web element
        Select dropdownList=new Select(dropdown);
        //get the selected option
       WebElement selectedOption= dropdownList.getFirstSelectedOption();
       //verify selected option
        Assert.assertEquals(selectedOption.getText(),"Please select an option");
    }
    @Test
    public void selectFromList() throws InterruptedException {
        //get the element with select tag
        WebElement dropdown=driver.findElement(By.id("state"));
        //create select class
        Select states=new Select(dropdown);
        //TODO ByVisibleText  --> selects by the text of the option
        states.selectByVisibleText("Iowa");
        Thread.sleep(2000);
        states.selectByVisibleText("California");
        Thread.sleep(2000);
        states.selectByVisibleText("Kentucky");
        Thread.sleep(2000);

        //TODO selectByIndex --> selects based on the index of the option, 0 based count
        states.selectByIndex(0);
        Thread.sleep(2000);
        states.selectByIndex(10);
        Thread.sleep(2000);
        states.selectByIndex(20);
        Thread.sleep(2000);

        //TODO selectByValue -->selects based on the value of the value attribute of the option
        //TODO selectByValue --> it is not select text
        states.selectByValue("VA");
        Thread.sleep(2000);
        states.selectByValue("SC");
        Thread.sleep(2000);
        states.selectByValue("CO");
        Thread.sleep(2000);

    }
    @Test
    public void getAllAvailableOptions(){
      Select monthList=new Select(driver.findElement(By.id("month")));
      //print the current selection
        System.out.println(monthList.getFirstSelectedOption().getText()); //March

        //TODO getOptions  --> return all of the available options from dropdown
        List<WebElement> allOptions=monthList.getOptions();

        System.out.println("Number of Months: "+allOptions.size());
        for(WebElement month:allOptions){
            System.out.println(month.getText());
        }
        //verify that months list always shows the current month as selected
        //get the current month
       String expected=LocalDate.now().getMonth().name();
        String actual=monthList.getFirstSelectedOption().getText();
        Assert.assertEquals(actual.toLowerCase(),expected.toLowerCase());

        //verify that months list has following values: January,...December
        List<String> expectedMonths=Arraylist.asList("January","February","March","April","May","June",
                "July","August","September","October","November","December");

        //getoptions gives me List webelements, so AllOptions is a list of webelements
        //but my expected is a String. I have to make sure the both list of Strings
        //I need to get list string from list of webelement

        List<String> actualmonths=new ArrayList<>();
        for(WebElement option:allOptions){
            actualmonths.add(option.getText());

        }
         Assert.assertEquals(expectedMonths,actualmonths);
    }
    @Test
    public void verifyOptions(){
        Select list=new Select(driver.findElement(By.id("dropdown")));
        //verify that list has three options
        int expectedSize=3;
        int actualSize=list.getOptions().size();
        List<String> expectedValues=Arrays.asList("Please select an option","Option 1","Option 2");

        List<String>actualValues=new ArrayList<>();
        for(WebElement option:list.getOptions()){
            actualValues.add(option.getText()) ;
        }
        Assert.assertEquals(actualValues,expectedValues);
    }
}
