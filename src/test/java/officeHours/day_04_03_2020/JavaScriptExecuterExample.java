package officeHours.day_04_03_2020;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecuterExample extends TestBase {
    @Test
    public void test(){
        driver.get(ConfigurationReader.getProperty("url"));
        driver.findElement(By.linkText("Dynamic Controls")).click();

        //input

       WebElement webelement= driver.findElement(By.cssSelector("#input-example>input"));

        JavascriptExecutor jse=(JavascriptExecutor)driver;
       // jse.executeScript("click",webelement);
        String text="hello";

        jse.executeScript("arguments[0].setAttribute('value', '"+text+"')", webelement);
    }
    @Test
    public void highlight(){

    }
    public static void highlight(WebElement element) throws InterruptedException {
        JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();

        jse.executeScript("arguments[0].setAttribute('style'),'background:yellow;border:2px solid red;");
                Thread.sleep(1000);
        jse.executeScript("arguments[0].removeAttribute('style'),'background:yellow;border:2px solid red;");
        Thread.sleep(1000);

    }
}
