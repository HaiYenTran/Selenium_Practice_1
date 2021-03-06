package PagesTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By formAuthenticationLink = By.linkText("Form Authentication");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickFormAuthentication(){
        driver.findElement(formAuthenticationLink).click();
        return new LoginPage(driver);
    }

    public DropdownPage clickDropDown(){
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    public HoverPage clickHovers(){
        clickLink("Hovers");
        return new HoverPage(driver);
    }

    public KeyPressPage clickKeyPresses(){
        clickLink("Key Presses");
        return new KeyPressPage(driver);
    }

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
}
