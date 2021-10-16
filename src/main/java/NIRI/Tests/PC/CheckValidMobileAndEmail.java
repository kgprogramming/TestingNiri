package NIRI.Tests.PC;

import NIRI.Pages.AboutUsPage;
import NIRI.Pages.HomePage;
import NIRI.SiteTools.BaseClass;
import NIRI.SiteTools.Constant;
import NIRI.SiteTools.Groups;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CheckValidMobileAndEmail extends BaseClass {

    final private HomePage homePage = new HomePage();
    final private AboutUsPage  aboutUsPagesPage= new AboutUsPage();

    @Test(groups = {Groups.PC})
    public void verifyDoesItEmailAndMobileNumberAreValid() {

        Reporter.log("Navigate to home page", true);
        homePage.navigateToPageNoCookie(Constant.MAIN_NAVIGATION_URL);
        checkPageIsReady();

        Reporter.log("Clicks on wanted menu link", true);
        homePage.clickOnNavigationHeadlineLink(Constant.NAVIGATION_MENU_LINK_FOR_ABOUT_US);
        checkPageIsReady();

        Reporter.log("Verify is it have email character @",true);
        Assert.assertTrue(aboutUsPagesPage.regexForEmail(".*@.*"));

        Reporter.log("Verify is it mobile phone number character +",true);
        Assert.assertTrue(aboutUsPagesPage.regexForMobilePhone(".*+.*"));

        Reporter.log("Verify does it mobile phone number have letters",true);
        Assert.assertFalse(aboutUsPagesPage.regexForMobilePhone("[a-zA-Z]"));

        Reporter.log("Verify does it mobile phone number have special characters",true);
        Assert.assertFalse(aboutUsPagesPage.regexForMobilePhone("[~!@#$%^&*()_{}:;,.<>/?-]"));

    }
    }
