package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class BrowserUtil  {

    public static void waitFor(int seconds){
        /*
        a method to pause the thread for certain seconds
        parameter- seconds
         */
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    // WebDriverWait wait=new WebDriverWait(utility.Driver.getDriver(),2);
    // check for visibility of error msg element in 2 sec

    /*
    This method will check the Visibility of elementt within the time given
    @param locator By whatever
    @param second time to wait
    @return true if element is found within the time and is visible

     */


    public static boolean checkVisibilityOfElement(By locator, int second){
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),second);
        // check for visibility of error msg element in 2 sec
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        }catch (TimeoutException e) {
            // System.out.println("The error msg is = "+e.getMessage());
            System.out.println("WE DID NOT SEE THE MESSAGE");
        }
        return false;
    }

    // method returning String list of all the texts from list of web elements
    public static List<String> getAllText(List<WebElement> lstOfWebElements){
        List<String> allTextLst = new ArrayList<>();
        for (WebElement eachElement : lstOfWebElements) {
            allTextLst.add(  eachElement.getText()  );
        }

        return  allTextLst ;
    }





}