package officeHours.day_03_04_2020;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumOH2 {
    /*
    1. go to http://automationpractice.com
    2. search for tshirt +click enter or search box
    3.validate you got no results message on UI
    4. search for t-shirt
    5.validate there was 1 found
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get(" http://automationpractice.com");
        WebElement searchBox=driver.findElement(By.id("search_query_top"));
        //WebElement-class in selenium /java and it has many useful methods
        //sendKeys("value that we want to send- input")
        searchBox.sendKeys("tshirt"+ Keys.ENTER);
        /*
        <p class="alert alert-warning>
        No results were found for your search&nbsp;"tshirt" </p>
         */
        Thread.sleep(3000);
        WebElement error=driver.findElement(By.xpath("//p[@class='alert alert-warning']"));
        String errorText=error.getText();
        //getText() -> return String (text) from the element
        System.out.println("Errror Message: "+errorText);
        //NoSuchElementException -it means we could not locate the element
        driver.findElement(By.id("search_query_top"));
        searchBox.clear();
        //
       searchBox.sendKeys("t-shirt "+Keys.ENTER);
       //StateElementReference-element is old/state- we want to find
        //this element again or refresh the page
        Thread.sleep(3000);
        WebElement count=driver.findElement((By.className("product-count")));
        System.out.println("Item found: "+count.getText());
        driver.quit();

        /*
        in html:
        a- link
        span-description
         */
    }
}
