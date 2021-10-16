package NIRI.Pages;

import LocalUtils.Annotations.WebElementLocator;
import LocalUtils.Annotations.WebElementLocatorFactory;
import NIRI.SiteTools.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartnershipPage extends BaseClass {

    // Web elements

    /**
     * tools and technology list
     *
     * @return Web element list
     */
    @WebElementLocator(webDesktop = "//div[@class='card wow fadeIn']//div[@class='card-body']", webPhone = "//div[@class='card wow fadeIn']//div[@class='card-body']")
    private static List<WebElement> toolsAndTechnology() {
        return getDriver().findElements(By.xpath(new WebElementLocatorFactory().getLocator(PartnershipPage.class, "toolsAndTechnology")));
    }

    /**
     * Web element for button lets talk
     * @return webElement
     */

    @WebElementLocator(webDesktop = "//div[@id='lets-talk']//a")
    private static WebElement buttonLetsTalk() {
        return getDriver().findElement(By.xpath(new WebElementLocatorFactory().getLocator(PartnershipPage.class, "buttonLetsTalk")));
    }
    // Actions

    public int getSizeFromListOfToolsAndTechnology() {
       return toolsAndTechnology().size();
    }

    public boolean verifyThatButtonLetsTalkIsVisibleAndClickable() {
        if (buttonLetsTalk().isDisplayed() && waitUntilElementIsClickableBool(buttonLetsTalk())) {
            return true;
        } else {
            return false;
        }
    }
    public boolean verifyThatFieldsForEmailNameAndButtonAreVisible(){
    if (getDriver().findElement(By.name("your-name")).isDisplayed()
           && getDriver().findElement(By.name("your-email")).isDisplayed()
            && getDriver().findElement(By.xpath("//button")).isDisplayed()){
        return true;
    }
    else {
        return false;
    }

    }

}
