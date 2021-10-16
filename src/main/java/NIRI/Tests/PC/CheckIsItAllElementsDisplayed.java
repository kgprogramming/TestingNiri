package NIRI.Tests.PC;

import NIRI.Pages.HomePage;
import NIRI.Pages.PartnershipPage;
import NIRI.SiteTools.BaseClass;
import NIRI.SiteTools.Constant;
import NIRI.SiteTools.Groups;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CheckIsItAllElementsDisplayed extends BaseClass {
    final private HomePage homePage = new HomePage();
    final private PartnershipPage partnershipPage=new PartnershipPage();
    @Test(groups = {Groups.PC})
    public void countAllWordsFromFormGetInTouch() {
        Reporter.log("Navigate to pc homepage", true);
        homePage.navigateToPageNoCookie(Constant.MAIN_NAVIGATION_URL);
        checkPageIsReady();

        Reporter.log("Click on partnership page",true);
        homePage.clickOnNavigationHeadlineLink(Constant.NAVIGATION_MENU_LINK_PARTNERSHIP);
        checkPageIsReady();

        Reporter.log("Asserts if all appearances number is not smaller than stated value", true);
        Assert.assertEquals(partnershipPage.getSizeFromListOfToolsAndTechnology(),Constant.NUMBER_OF_ELEMENTS_FOR_TOOL);

        Reporter.log("Number of elements for tools and technology are: "+Constant.NUMBER_OF_ELEMENTS_FOR_TOOL, true);

        Reporter.log("Button lets talk is visible and clickable",true);
        Assert.assertTrue(partnershipPage.verifyThatButtonLetsTalkIsVisibleAndClickable());

         Reporter.log("Elements from form get in touch is visible",true);
        Assert.assertTrue(partnershipPage.verifyThatFieldsForEmailNameAndButtonAreVisible());
    }
}
