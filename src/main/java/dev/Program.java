package dev;

import org.openqa.selenium.WebDriver;

public class Program {

    static WebDriver driver;
    public static void main(String[] args) {
        setUpDriver();
        Login login = new Login(driver);
    }

    public static void setUpDriver(){
        driver = utility.Driver.getDriver();
    }

}
