package Modules;

import PagesTest.KeyPressPage;
import base.BaseTest;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class KeysTest extends BaseTest {
    @Test
    public void testBackspace(){
        KeyPressPage keyPage = homePage.clickKeyPresses();
        keyPage.enterText("A" + Keys.BACK_SPACE);
        assertEquals(keyPage.getResult(), "You entered: BACK_SPACE");
    }

    @Test
    public void testPi(){
        KeyPressPage keyPage = homePage.clickKeyPresses();
        keyPage.enterPi();
    }
}
