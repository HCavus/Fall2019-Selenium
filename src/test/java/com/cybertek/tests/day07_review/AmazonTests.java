package com.cybertek.tests.day07_review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//TODO: This AmazonTests class will throw exception
public class AmazonTests {
    //main method to invoke the test
    public static void main(String[] args) throws InterruptedException {
     // nameMatchTest();
      secondNameMatchTest();
    }

    private static void secondNameMatchTest() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");
        String searchTerm="disinfectant wipes";
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(searchTerm);

        WebElement searchBtn=driver.findElement(By.className("nav-input"));
        searchBtn.click();
        Thread.sleep(2000);

       //find the first result
        WebElement secondResult=driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]"));
        System.out.println(secondResult.getText());

        //click on the first result

        Thread.sleep(2000);

        //get the text of the second result
        String expectedName=secondResult.getText();
        secondResult.click();
        WebElement productName=driver.findElement(By.id("productTitle"));
        String actualName=productName.getText();
        System.out.println(actualName);
        if(expectedName.equals((actualName))){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected name: "+expectedName);
            System.out.println("Actual name: "+actualName);

        }
        driver.close();

    }

    //each test will be a separate method
    /*
    1.open browser
    2.go to amazon
    3.search for any item
    4.remember the name of first result
    5.click on the first result
    6.verify that product name is the same in the product page
     */
    private static void nameMatchTest() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");

        String searchTerm="disinfectant wipes";
        WebElement searchInput=driver.findElement(By.id("twotabsearchtextbox"));
        //OPTION 1.enter search term and hit ENTER button
       // searchInput.sendKeys(searchTerm+ Keys.ENTER);
        //OPTION 2.Enter search term and
        searchInput.sendKeys(searchTerm);
        WebElement searchBtn=driver.findElement(By.className("nav-input"));
        searchBtn.click();
        Thread.sleep(2000);
        //write xpath that captures the first result
        WebElement firstResult=driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
        //get the name of first result
        String expectedName=firstResult.getText();

        firstResult.click();
        WebElement productName=driver.findElement(By.id("productTitle"));
        String actualName=productName.getText();
        System.out.println(actualName);
        if(expectedName.equals((actualName))){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected name: "+expectedName);
            System.out.println("Actual name: "+actualName);

        }
        driver.close();

    }


}
