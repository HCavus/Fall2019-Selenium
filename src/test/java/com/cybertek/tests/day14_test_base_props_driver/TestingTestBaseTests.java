package com.cybertek.tests.day14_test_base_props_driver;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestingTestBaseTests extends TestBase {
@Test
    public void testTitle(){
    String url= ConfigurationReader.getProperty("url");
    driver.get(url);

    Assert.assertEquals(driver.getTitle(),"Practice");
    System.out.println(driver.getTitle());
    System.out.println(driver.getCurrentUrl());
}
    @Test
    public void testVytrackTitle(){
    String url=ConfigurationReader.getProperty("vytrack_url");
    driver.get(url);

    Assert.assertEquals(driver.getTitle(),"Login");
        System.out.println("Title: "+driver.getTitle());
        System.out.println("Current url: "+driver.getCurrentUrl());
        Assert.assertFalse(url.equals(driver.getCurrentUrl()));
    }
}
