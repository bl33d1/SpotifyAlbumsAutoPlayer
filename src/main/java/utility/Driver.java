package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
Create a Singleton class called utility.Driver

1. create private no arg constructor

2. create private static field with name obj
     Data type of variable should be WebDriver

3. create public static method
     name : getDriver()
     return type :WebDriver
     param : none

     check if obj is null or not
         if yes - create ChromeDriver with all set up
        if no  -- return same obj
 */
public class Driver {
    private static WebDriver obj;
    private Driver(){

    }
    public static WebDriver getDriver(){
        // read the browser type u want to launch from properties file
        String browserName=ConfigReader.read("browser");

        if (obj==null){
            switch (browserName.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    obj = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    obj = new FirefoxDriver();
                    break;
                default:
                    obj = null;
                    System.out.println("Invalid Browser Type " + browserName);

            }
            //  System.out.println("object not created. creating one now");
            //  WebDriverManager.chromedriver().setup();
            //  obj=new ChromeDriver();
        }else {
            //  System.out.println("object already exists");
            return obj;
        }
        return obj;
    }
    public static void closeBrowser(){
        if (obj!=null){
            obj.quit();
            obj=null;
        }

    }

}