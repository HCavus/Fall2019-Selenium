package com.cybertek.tests.day15_webtables;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebtablesTests extends TestBase {
    @BeforeMethod
    public void setUp(){
        String url= ConfigurationReader.getProperty("url");
        driver.get(url);
        driver.findElement(By.linkText("Sortable Data Tables")).click();
    }


    //GET WHOLE TABLE
    @Test
    public void printTable(){

        WebElement myTable=driver.findElement(By.id("table1"));
        System.out.println(myTable.getText());

    }
    //GET ALL HEADERS
    @Test
    public void getHeaders(){
        //get all headers in a single element
      WebElement header=driver.findElement(By.tagName("thead")); //Last Name First Name Email Due Web Site Action
        System.out.println(header.getText());

        List<WebElement> headers=driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println(headers.size());
        //prints in different line
        for(WebElement each: headers){
            System.out.println(each.getText());
        }
        //prints in a single line using BrowserUtils to get the list of the headers as text
        System.out.println(BrowserUtils.getElementsText(headers)); //[Last Name, First Name, Email, Due, Web Site, Action]
    }
    //GET TABLE SIZE
    @Test
    public void getTableSize(){
        //get number of cols
        List<WebElement> headers=driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("Number of Columns: "+headers.size()); //6

        //get number of rows including header
        List<WebElement> rowsWithHeader=driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("Number of rows with header: "+rowsWithHeader.size());  //5

        //get number of rows without header
        List<WebElement> rowsWithoutHeader=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("Number of rows without header: "+rowsWithoutHeader.size()); //4

    }
    //GET SINGLE ROW BY INDEX
    @Test
    public void getSingleRowByIndex(){
        //get the first row (in the body)
        WebElement row=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]"));
        System.out.println(row.getText());

        //get the third row (in the body) dynamic xpath
        String xpath=getTableRowXPath(3);
        row=driver.findElement(By.xpath(xpath));
        System.out.println(row.getText());
    }

    //getTableRowXPath based on index
    public static String getTableRowXPath(int index){
        String xpath="//table[@id='table1']/tbody/tr["+index+"]";
        return xpath;
    }
    //GET SINGLE CELL BASED ON INDEX
    @Test
    public void getSingleBasedByIndex(){
        WebElement cell=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[1]"));
        System.out.println(cell.getText());

        String xpath=getCellXpathByIndex(2,3);
        cell=driver.findElement(By.xpath(xpath));
        System.out.println(cell.getText());


    }
    public static String getCellXpathByIndex(int row, int column){
        String xpath="//table[@id='table1']/tbody/tr["+row+"]/td["+column+"]";
        return xpath;
    }

    //GO THROUGH THE TABLE USING LOOPS AND GET AL  VALUES
    @Test
    public void iterateTheTableUsingLoops(){
        //get the number of rows
        int rowCount=getRowCount();
        //get the number of cols
        int colCount=getColCount();

        for(int i=1; i<=rowCount;i++){
           for(int j=1;j<=colCount;j++){
               String xpath=getCellXpathByIndex(i,j);
               WebElement cell=driver.findElement(By.xpath(xpath));
               System.out.println(cell.getText());
           }
        }
    }
    //return numbers of rows excluding the table headers
    public int getRowCount(){
      return   driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

    }
    public int getColCount(){
        return driver.findElements(By.xpath("//table[@id='table1']//th")).size();
    }

    //get cell in relation to another cell
    //verify that Jason has
    @Test
    public void verifyCellValueByOtherCell(){
        String firstName="Jason";
        String xpath="//table[@id='table1']//td[2][.='"+firstName+"']/../td[4]"; //finds the parent then child again
    WebElement amount=driver.findElement(By.xpath(xpath));
        System.out.println(amount.getText());
        Assert.assertEquals(amount.getText(),"$100.00");
    }
    public String getXpathForValue(String value, String columnIdx){
        String xpath="//table[@id='table1']//td[2][.='"+value+"']/../td["+columnIdx+"']";
        return xpath;
    }
}
