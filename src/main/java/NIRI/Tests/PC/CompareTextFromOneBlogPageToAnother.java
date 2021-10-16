package NIRI.Tests.PC;

import NIRI.Pages.BlogPage;
import NIRI.Pages.HomePage;
import NIRI.SiteTools.BaseClass;
import NIRI.SiteTools.Constant;
import NIRI.SiteTools.Groups;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CompareTextFromOneBlogPageToAnother extends BaseClass {

    final private HomePage homePage = new HomePage();
    final private BlogPage blogPage=new BlogPage();
    @Test(groups = {Groups.PC})
    public void compareTwoPagesFromBlog() throws InterruptedException {
        Reporter.log("Navigate to homepage", true);
        homePage.navigateToPageNoCookie(Constant.MAIN_NAVIGATION_URL);
        checkPageIsReady();

        Reporter.log("Clicks on wanted menu link", true);
        homePage.clickOnNavigationHeadlineLink(Constant.NAVIGATION_MENU_LINK1);
        checkPageIsReady();

        Reporter.log("Verify that number of elements on page are ten",true);
        Assert.assertEquals(blogPage.allPostFromBlogPage(),Constant.NUMBER_OF_ELEMENTS_ON_BLOG_PAGE);

        Reporter.log("Verify that text from page 1 is not same as text from page 2",true);
        Assert.assertTrue(blogPage.isItTextEqualsFromPageOne());

    }
}
