package officeHours.day_03_17_2020;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class Vytrack {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://qa3.vytrack.com");
        Thread.sleep(2000);
        WebElement usernameBox=driver.findElement(By.id("prependedInput"));
        usernameBox.sendKeys("salesmanager110");
        Thread.sleep(2000);
        WebElement passwordBox=driver.findElement(By.id("prependedInput2"));
        passwordBox.sendKeys("UserUser123");
        passwordBox.submit();
        Thread.sleep(2000);
        //click on contact
        //create contact
        //use map to store information and use it later to enter in UI
        //tag[@attribute='value']
        WebElement contactLink=driver.findElement(By.xpath("//span[.='Contacts']/following-sibling::a"));
        Thread.sleep(2000);
        contactLink.click();
        Thread.sleep(2000);
        WebElement createContact=driver.findElement(By.linkText("Create Contact"));
        createContact.click();
        Thread.sleep(2000);
        String currentTitle=driver.getTitle();
        if(currentTitle.equalsIgnoreCase("Create Contact - Contacts - Customers")){
            System.out.println("Title is expected");
        }else{
            System.out.println("Title is NOT expected");
        }
        HashMap<String,String> contact1=new HashMap<>();
        contact1.put("First Name","John");
        contact1.put("Last Name","Smith");
        contact1.put("Phone","571-236-4565");
        contact1.put("Street","400 Main Street");
        contact1.put("City","Tysons");
        contact1.put("State","VA");
        contact1.put("Zip Code","22102");
        contact1.put("Sales Group","true");
        contact1.put("Country","United States");
        System.out.println("Contact 1: "+contact1);




    }
}
