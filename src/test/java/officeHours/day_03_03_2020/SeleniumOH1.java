package officeHours.day_03_03_2020;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SeleniumOH1 {
    /*
    -Iterator
        -List,Set,Map,and other types of collections can use Iterator class to iterate over that collection
         -List has indexes(for i, for each,while, iterator)
         -Map (for each,Iterator,-to loop through keys0
    -Basic Selenium Navigations-
     */
    public static void main(String[] args) {
        //create ArrayList of String -iterate over it
        ArrayList<String> keyToSearch = new ArrayList<>();
        keyToSearch.add("fruits");
        keyToSearch.add("veggies");
        keyToSearch.add("berries");
        Iterator<String> iterator = keyToSearch.iterator();
        //iterator() -return Iterator type which we can use with all iterator methods
        //[fruits , veggies, berries]
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //print before modification
        //add * to each string and print again
        Iterator<String> iterator1 = keyToSearch.iterator();
        while (iterator1.hasNext()) {
            String item = iterator1.next();
            System.out.println(item);
            System.out.println("*" + item);
        }
        System.out.println();
        //create a map with <String,String>
        HashMap<String, String> personalInfo = new HashMap<>();
        personalInfo.put("name", "Bryan");
        personalInfo.put("studentID", "2314635541");
        personalInfo.put("major", "science");

        Iterator<String> mapIterator = personalInfo.keySet().iterator();
        while (mapIterator.hasNext()) {
            String key = mapIterator.next();
            System.out.println(mapIterator.next() + " : " + personalInfo.get(key));
        }

        //=======================================
        //SELENIUM
        /*
        id(it is not always available
        class-classname
        tag-every element will have a tag

        will only work with the link
        linktext
        partial linktext

        locator that is using html (syntax)
        css
        xpath
        ---------------------------
        input-tag
        key="value"-attributes
        id="global-enhancements-search-query" -one of the attributes
        we can use id to locate the element

        name="search-query" -attribute -we can use name to locate the element
        class="wt-input wt-input btn-group_input
        global enhancements-search-input-btn-group_input wt-pr-xs-7
        -we can use class to locate element

        whe we want to find element it is always must be unique
        id-always unique
        name, tag, class-are not unique often

         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://etsy.com");

        WebElement searchBar=driver.findElement(By.id("global-enhancements-search-query"));
        //find element() --> returns WebElement
        //as a param we put By.locator("value of attribute")
        //                              (id, name, classname,
    }
}