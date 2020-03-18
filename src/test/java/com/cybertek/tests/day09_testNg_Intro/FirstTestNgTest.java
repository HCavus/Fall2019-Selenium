package com.cybertek.tests.day09_testNg_Intro;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class FirstTestNgTest {

   @Test
    public void test1(){
       System.out.println("test one");
   }
   //@Ignore
   @Test
   public void test2(){
       System.out.println("test two");
   }
    @Test
    public void test3(){
        System.out.println("test three");
    }
}
