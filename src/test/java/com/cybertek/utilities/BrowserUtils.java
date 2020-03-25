package com.cybertek.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {
    /*
    takes a list of web elements
    return a list of strings
     */
    public static List<String> getElementsText(List<WebElement> listEl){
        //given a list of webelements, extract the text of the elements into new list of Strings
        List<String> listSt=new ArrayList<>();
        for(WebElement element: listEl){
            listSt.add(element.getText());
        }
        return listSt;
    }
}
