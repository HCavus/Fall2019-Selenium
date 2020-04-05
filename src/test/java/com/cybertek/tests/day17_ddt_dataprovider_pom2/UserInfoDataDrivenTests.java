package com.cybertek.tests.day17_ddt_dataprovider_pom2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserInfoDataDrivenTests {
    @Test(dataProvider  ="users")
    public void test(String username, String password,int number){
        System.out.println("Opening application");
        System.out.println("Login as : "+username);
        System.out.println("Number as : "+number);
        System.out.println("verify info: ");
    }
    @DataProvider(name="users")
    public Object[][] getUsers(){
        return new Object[][]{

                {"user1","UserUser123",25},
                {"salesmanager355","UserUser123",26},
                {"storemanager","UserUser123",325},
                {"salesmanager","UserUser123",262},

        };
    }

}
