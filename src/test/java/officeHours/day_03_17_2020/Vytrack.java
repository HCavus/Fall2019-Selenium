package officeHours.day_03_17_2020;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

        WebElement first_name=driver.findElement(By.xpath("(//input[@data-name='field__first-name'])[1]"));
        WebElement last_name=driver.findElement(By.xpath("(//input[@data-name='field__last-name'])[1]"));
        WebElement phone=driver.findElement(By.name("oro_contact_form[phones][0][phone]"));
        WebElement street=driver.findElement(By.name("oro_contact_form[addresses][0][street]"));
        WebElement city=driver.findElement(By.name("oro_contact_form[addresses][0][city]"));
        WebElement state=driver.findElement(By.xpath("//input[@data-name='field__region-text']"));
        WebElement zipCode=driver.findElement(By.name("oro_contact_form[addresses][0][postalCode]"));
        WebElement salesGroup=driver.findElement(By.xpath("(//input[@data-name = 'field__1'])[2]"));
        first_name.sendKeys(contact1.get("First Name"));
       last_name.sendKeys(contact1.get("Last Name"));
        phone.sendKeys(contact1.get("Phone"));
       street.sendKeys(contact1.get("Street"));
       city.sendKeys(contact1.get("City"));
       state.sendKeys(contact1.get("State"));
       zipCode.sendKeys(contact1.get("Zip Code"));

        /*
        to handle dropdowns in selenium we are using Select class
        to use it we have to ensure we have <select></select> tag in our dropdown
        to create select class we are using webElement of <select></select> element from html
        (we need to locate our dropdown which should have select tag)
         */
        WebElement country=driver.findElement(By.className("select2-chosen"));
        // WebElement country=driver.findElement(By.name("oro_contact_form[addresses][0][country]"));
        Select country_dropdown=new Select(country); //this is special class in selenium to handle dropdowns
        /*
        it has different methods that helps us interact with dropdown
         */
        country_dropdown.selectByVisibleText(contact1.get("Country"));
        if(contact1.get("Sales Group").equalsIgnoreCase("true")){
           salesGroup.click();
        }
    }
}
