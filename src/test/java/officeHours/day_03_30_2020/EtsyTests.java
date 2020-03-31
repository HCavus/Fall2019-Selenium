package officeHours.day_03_30_2020;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

       //verify Ship to Location
       System.out.println("VERIFYING SHIP TO LOCATION");

       //wait until element is found in HTML
       driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
       Select shipToList=new Select(driver.findElement(By.name("ship_to")));
       String expectedDefaultCountry="United States";
       //get the selected element
       String actualDefaultCountry=shipToList.getFirstSelectedOption().getText().trim();
       Assert.assertEquals(actualDefaultCountry,expectedDefaultCountry);

       //get all options in a list
       List<String> options=BrowserUtils.getElementsText(shipToList.getOptions());
       //verify ship to includes Australia
      Assert.assertTrue(options.contains("Australia"));

      //verify FREE SHIPPING IS  nOT CLICKED
       WebElement freeShipping=driver.findElement(By.name("free_shipping"));
       Assert.assertFalse(freeShipping.isSelected());

       //verify url changes when free shipping is clicked
       WebElement freeShippinglabel=driver.findElement(By.xpath("//label[.='FREE shipping']"));
       freeShippinglabel.click();
       String expectedURL="free_shipping=true";
       String actualURL=driver.getCurrentUrl();
       Assert.assertTrue(actualURL.endsWith(expectedURL));



   }

}
