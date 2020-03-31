package officeHours.day_03_30_2020;
import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DifferentBrowsers extends TestBase {
    @Test
    public void test(){
        //Which Browser am I using now
        //get the value from properties file
        System.out.println("OPTION 1");
        System.out.println(ConfigurationReader.getProperty("browser"));
        //get the value from the web driver
        System.out.println("OPTION 2");
        System.out.println(driver);
        if(driver.toString().contains("FirefoxDriver")){
            System.out.println("this is firefox");
        }else if(driver.toString().contains("ChromeDriver")){
            System.out.println("this is chrome");
        }
        //use the instanceof keyword
        System.out.println("OPTION 3");
        if(driver instanceof FirefoxDriver) {
            System.out.println("this is firefox");
        }else if(driver instanceof ChromeDriver){
            System.out.println("this is chrome");
        }
    }
}
