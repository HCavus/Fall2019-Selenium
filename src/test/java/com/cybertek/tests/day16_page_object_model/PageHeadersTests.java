package com.cybertek.tests.day16_page_object_model;

import com.cybertek.base.VytrackTestBase;
import com.cybertek.pages.DashboardPage;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PageHeadersTests extends VytrackTestBase {
    /*
    1.go to qa3.vytrack.com
    2.login as driver
    3.verify hearder is "Quick Launch"
     */
    @Test
    public void dashboardPageTest(){
        String username= ConfigurationReader.getProperty("driver_username");
        String password= ConfigurationReader.getProperty("driver_password");
        loginpage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage();
        wait.until(ExpectedConditions.textToBePresentInElement(dashboardPage.pageHeader,"Quick Launchpad"));
        String actual = dashboardPage.pageHeader.getText();
        assertEquals(actual, "Quick Launchpad");
    }
     /*
    go to qa1.vytrack.com/
    go to Fleet vehicles
    login as driver
    verify header is "Cars"
     */
    @Test
    public void fleetVehiclesTest(){
        //use login to login
        String username= ConfigurationReader.getProperty("driver_username");
        String password= ConfigurationReader.getProperty("driver_password");
        loginpage.login(username, password);

        //use dashboard to change page
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.fleet));
        dashboardPage.fleet.click();

        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.vehicles));
        dashboardPage.vehicles.click();

        // use the fleet / vehicles page to get text
        wait.until(ExpectedConditions.textToBePresentInElement(vehiclesPage.pageHeader,"Cars"));
        String actual=vehiclesPage.pageHeader.getText();
        Assert.assertEquals(actual,"Cars");
    }
}
