package officeHours.day_03_30_2020;

import com.cybertek.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EtsyTests extends TestBase {

    /*
    search for wooden spoon on etsy
    verify that default ship to location is Ship to
    verify Ship to countries include Australia
     */
   @Test
    public void verifyCountryList(){
       driver.get("https://www.etsy.com");
       WebElement input=driver.findElement(By.id("global-enhancements-search-query"));
       input.sendKeys("wooden spoon"+ Keys.ENTER);
       String expectedTitle="Wooden spoon | Etsy";
       //wait until title changes to right one
       WebDriverWait wait=new WebDriverWait(driver,10);
       //using explicit wait to wait until title contains Wooden spoon | Etsy
       wait.until((ExpectedConditions.titleIs(expectedTitle)));
       Assert.assertEquals(driver.getTitle(),expectedTitle);
   }

}
