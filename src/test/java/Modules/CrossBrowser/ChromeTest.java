package Modules.CrossBrowser;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

// Initialize browser
        WebDriver driver=new ChromeDriver();

// Open facebook
        driver.get("http://www.google.com");

// Maximize browser

        driver.manage().window().maximize();

    }
}
