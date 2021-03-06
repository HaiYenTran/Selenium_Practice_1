package Supports;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.How;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Browser {
    private static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }

    public static void open(String name) {
        if ("ie".equals(name.toLowerCase())) {
            driver = new InternetExplorerDriver();
        } else if ("edge".equals(name.toLowerCase())) {
            driver = new EdgeDriver();
        } else if ("firefox".equals(name.toLowerCase())) {
            driver = new FirefoxDriver();
        } else if ("chrome".equals(name.toLowerCase())) {
            driver = new ChromeDriver();
        } else if ("safari".equals(name.toLowerCase())) {
            driver = new SafariDriver();
        } else if ("chrome_headless".equals(name.toLowerCase())) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        } else if ("firefox_headless".equals(name.toLowerCase())) {
            FirefoxBinary firefoxBinary = new FirefoxBinary();
            firefoxBinary.addCommandLineOptions("--headless");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBinary(firefoxBinary);
            driver = new FirefoxDriver(firefoxOptions);
        } else {
            throw new IllegalStateException("Undefine browser : " + name);
        }

    }

    public static void visit(String url) {
        driver.get(url);
    }

    public static void navigate(String url) {
        driver.navigate().to(url);
    }

    public static void reloadPage() {
        driver.navigate().refresh();
    }

    public static void backToPreviousPage() {
        driver.navigate().back();
    }

    public static WebElement find(How how, String locator) {
        return driver.findElement(how.buildBy(locator));
    }

    public static WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public static void fill(How how, String locator,String withText){
        find(how, locator).clear();
        find(how, locator).sendKeys(withText);
    }
    public static void fill(By locator,String withText){
        find(locator).clear();
        find(locator).sendKeys(withText);
    }

    public static void click(How how, String locator){
        find(how, locator).click();
    }
    public static void click(By locator){
        find(locator).click();
    }

    public static void check(How how, String locator){
        if(!find(how, locator).isSelected()){
            click(how, locator);
        }
    }

    public static void uncheck(How how, String locator){
        if(find(how, locator).isSelected()){
            click(how, locator);
        }
    }

    public static String text(How how, String locator){
        return find(how, locator).getText();
    }

    public static String text(By locator){
        return find(locator).getText();
    }
    public static List<WebElement> all(How how, String locator){
        return driver.findElements(how.buildBy(locator));
    }

    public static List<WebElement> all(By locator){
        return driver.findElements(locator);
    }


    public static void doubleClick(How how, String locator){
        Actions dbClick = new Actions(driver);
        dbClick.doubleClick(find(how, locator)).perform();
    }
    public static void doubleClick(By locator){
        Actions dbClick = new Actions(driver);
        dbClick.doubleClick(find(locator)).perform();
    }

    public static void doubleClick(WebElement element){
        Actions dbClick = new Actions(driver);
        dbClick.doubleClick(element).perform();
    }
    public static void hover(How how, String locator){
        Actions hover = new Actions(driver);
        hover.moveToElement(find(how, locator)).perform();
    }

    public static void hover(By locator){
        Actions hover = new Actions(driver);
        hover.moveToElement(find(locator)).perform();
    }

    public static void hover(WebElement element){
        Actions hover = new Actions(driver);
        hover.moveToElement(element).perform();
    }
    public static void captureScreenshot(){
        File screenShot =  ( (TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShot, new File("./target/screenshot-"+ System.currentTimeMillis()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void close(){
        if(driver != null){
            driver.quit();
        }
    }
}
