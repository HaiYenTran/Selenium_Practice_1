package Modules.Dropdown;

import PagesTest.DropdownPage;
import base.BaseTest;
import org.testng.annotations.Test;

public class DropdownTest extends BaseTest {
    @Test
    public void testSelectOption(){
        DropdownPage dropDownPage = homePage.clickDropDown();

        String option = "Option 1";
        dropDownPage.selectFromDropDown(option);
//        var selectedOptions = dropDownPage.getSelectedOptions();
//        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
//        assertTrue(selectedOptions.contains(option), "Option not selected");
    }
}
