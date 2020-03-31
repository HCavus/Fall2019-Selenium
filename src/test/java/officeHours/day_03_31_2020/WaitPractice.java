package officeHours.day_03_31_2020;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitPractice extends TestBase {
    /*
    Tell me Selenium Waits?
    Implicit wait-set it one time and it will work for every finElement method.
    -No such element exception
    -when it finds before the time it will not wait until the time completed

    Thread.sleep -not Selenium wait. It is Java class, sleep is a method of Thread class.
    -it basically stops the execution of java program
    -we never want to use this method in our tests.

    Explicit wait -we have to declare before the interaction with element
    expected condition we are looking for

    Singleton-it helps us to make sure we have only 1 instance driver object at a time
     */
    /*
    http://qa3.vytrack.com
    salesmanager110
    UserUser123
     */
    @Test
    public void testWait(){
        driver.get("http://qa3.vytrack.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //we want to find the title of the page
        //we need to create explicit wait
        WebDriverWait wait=new WebDriverWait(driver,10);
       wait.until(ExpectedConditions.titleIs("Login"));


        WebElement user=driver.findElement(By.id("prependedInput"));
        WebElement password=driver.findElement(By.id("prependedInput2"));
        WebElement submit=driver.findElement(By.id("_submit"));

        user.sendKeys("salesmanager110");
        password.sendKeys("UserUser123");
        submit.click();


        //we need to wait until the page loaded. Since we use findElement method it is implicit wait.
        WebElement account=driver.findElement(By.xpath("//span[.='Accounts']/following-sibling::span/following-sibling::a"));
        wait.until(ExpectedConditions.elementToBeClickable(account));
        account.click();


    }
}
