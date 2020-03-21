package com.cybertek.tests.day10_webelements;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderOftests {
    String title;
    @Test(priority=0)
    public void login(){
        System.out.println("Opening the browser");
        System.out.println("capturig title");
        title="cbt";
    }
    @Test(priority=1)
    public void assertTitle(){
        System.out.println("Verifying the title");
        Assert.assertEquals(title,"cbt");
    }
     @Test(priority=55)
    public void verifyOtherThings(){
         System.out.println("verify the sth else");
     }
}
