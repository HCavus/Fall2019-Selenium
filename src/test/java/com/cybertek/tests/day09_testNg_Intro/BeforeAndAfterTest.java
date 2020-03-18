package com.cybertek.tests.day09_testNg_Intro;

import org.testng.Assert;
import org.testng.annotations.*;

public class BeforeAndAfterTest {
    @BeforeClass
    public void beforeClass(){
        System.out.println("\tBEFORE CLASS");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("\tAFTER CLASS");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("\tBEFORE METHOD");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("\tAFTER METHOD");
    }
    @Test
    public void test1(){
        System.out.println("This is test one");
        Assert.assertEquals(true,true);
    }
   // @Ignore
    @Test
    public void test2(){
        System.out.println("This is test two");
    }

}
