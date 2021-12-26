package dev;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.*;
import utility.BrowserUtil;
import utility.ConfigReader;

import java.util.List;


public class Login {

    WebDriver driver;
    WebDriverWait wait;


    public Login(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
        openLoginPage();
        sendCredentials();
        playPlaylist("https://open.spotify.com/album/6vdFSyhPjL4dZFkgRtToXH");
    }




    public void openLoginPage(){
        //front page
        driver.get("https://open.spotify.com/");
        //login button
        WebElement loginButton = driver.findElement(By.xpath("//*[@data-testid='login-button']"));
        loginButton.click();
        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(driver.getTitle(),"Login - Spotify");
    }

    public void sendCredentials(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Email address or username']")));

        ////*[@data-testid='google-login']
        WebElement usernameInput = driver.findElement(By.xpath("//*[@placeholder='Email address or username']"));
        WebElement passwordInput = driver.findElement(By.xpath("//*[@placeholder='Password']"));
        usernameInput.sendKeys(ConfigReader.read("username"));
        passwordInput.sendKeys(ConfigReader.read("password"));
        ////*[@id='login-button']
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='login-button']"));
        loginButton.click();
        wait.until(ExpectedConditions.titleIs("Spotify – Web Player"));

    }

    public void playPlaylist(String url){
        driver.get(url);

//
//        WebElement greenPlayButton = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[3]/main/div[2]/div[2]/div/div/div[2]/section/div[3]/div/button[1]"));
//        greenPlayButton.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[3]/main/div[2]/div[2]/div/div/div[2]/section/div[1]/div[5]/h2"))));

        List<WebElement> playButtons = driver.findElements(By.xpath("//*[@data-testid='play-button']"));
        playButtons.get(2).click();

        List<WebElement> countSongs = driver.findElements(By.xpath("//*[@id=\"main\"]/div/div[2]/div[3]/main/div[2]/div[2]/div/div/div[2]/section/div[4]/div[1]/div[2]/div[2]/div"));

        for (int i = 0; i < countSongs.size(); i++) {
            //forward button
            driver.findElement(By.xpath("//*[@control-button-skip-forward']")).click();
            BrowserUtil.waitFor(5);
        }

    }
}
