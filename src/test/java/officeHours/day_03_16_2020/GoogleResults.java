package officeHours.day_03_16_2020;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class GoogleResults {
    public static void main(String[] args) {
      WebDriver driver= WebDriverFactory.getDriver("chrome");
      driver.get("https://google.com");
        List<String> searchStrs = Arrays.asList("Java", "cucumber bdd",
                "Selenium web browser automation");
for(String searchStr : searchStrs){
    WebElement searchInput=driver.findElement(By.name("q"));

    //this is for setting up for second input
    searchInput.clear();
    searchInput.sendKeys(searchStr+ Keys.ENTER);
    WebElement url=driver.findElement(By.cssSelector(".iUh30.tjvcx"));
   String expectedUrl=url.getText();
    System.out.println(url.getText());

    WebElement link=driver.findElement(By.cssSelector("div.r>a>h3"));
    link.click();

    if(expectedUrl.equals(driver.getCurrentUrl())) {
        System.out.println("Pass");
    }else{
        System.out.println("Fail");
        System.out.println("Expected: "+expectedUrl);
        System.out.println("Actual: "+driver.getCurrentUrl());
    }
    driver.navigate().back();
}
driver.quit();
    }

}
