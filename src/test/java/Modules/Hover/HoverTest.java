package Modules.Hover;

import PagesTest.HomePage;
import PagesTest.HoverPage;
import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class HoverTest extends BaseTest {
    @Test
    public void testHoverUser1(){
        HoverPage hoversPage = homePage.clickHovers();
        HoverPage.FigureCaption caption = hoversPage.hoverOverFigure(1);
        assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        assertEquals(caption.getTitle(), "name: user1", "Caption title incorrect");
        assertEquals(caption.getLinkText(), "View profile", "Caption link text incorrect");
        assertTrue(caption.getLink().endsWith("/users/1"), "Link incorrect");
    }
}
