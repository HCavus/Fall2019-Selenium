package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    /*
    Write a return method which returns WebDriver
    method name: getDriver()
    it takes a String as a parameter--> browser type
    returns ChromeDriver and FireFoxDriver
     */
    public static WebDriver getDriver(String browserType) {
        //local variables must be initialized
        WebDriver driver=null;
    switch(browserType.toLowerCase()){
        case "chrome":
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
            break;
        case "firefox":
            WebDriverManager.firefoxdriver().setup();
           driver=new FirefoxDriver();
           break;

    }
    return driver;

    }
}
