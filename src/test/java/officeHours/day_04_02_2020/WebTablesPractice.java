package officeHours.day_04_02_2020;

import com.cybertek.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesPractice extends TestBase {
    @BeforeMethod
    public void setUpTests(){
        driver.get("https://mockaroo.com/");
        driver.findElement(By.id("num_rows")).clear();
        driver.findElement(By.id("num_rows")).sendKeys("15");
        driver.findElement(By.id("preview")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.switchTo().frame("preview_iframe");
    }
    @Test
    public void testHeaderCount(){

   WebElement table= driver.findElement(By.xpath("//table"));
        System.out.println(table.getText());

        //get all the in the table
        List<WebElement> headers=driver.findElements(By.xpath("//table[@style]//th"));
        Assert.assertEquals(headers.size(),6);
    }
    //verify that value of each entry under gender column is equal to Male or Female
    @Test
    public void verifygender(){
       List<WebElement> allgenders= driver.findElements(By.xpath("//table[@style]/tbody/tr/td[5]"));
        System.out.println(allgenders.size()); //15
        //go through the list
        //verify that values is either Male or Female
        for(WebElement gender:allgenders){
            String actual=gender.getText();
            Assert.assertTrue(actual.equals("Male") || actual.equals("Female"));
        }
    }
}
