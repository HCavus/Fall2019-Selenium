package com.cybertek.tests.day04_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class PracticeFactory {
    public static void main(String[] args) {
        //go to google
        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        driver.get("http://google.com");
    }
}
