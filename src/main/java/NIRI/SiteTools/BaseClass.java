package NIRI.SiteTools;


import LocalUtils.UtilsBaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashSet;
import java.util.List;


public class BaseClass extends UtilsBaseClass {

    public  boolean waitUntilElementIsVisibleBool(By locator) {
        try {
            waiter().until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public boolean waitUntilElementIsClickableBool(WebElement locator) {
        try {
            waiter().until(ExpectedConditions.elementToBeClickable(locator)).click();
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public WebDriverWait waiter() {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 70,500);
        return wait;
    }

    public JavascriptExecutor getExecutor() {
        JavascriptExecutor executor = (JavascriptExecutor) getWebDriver();
        return executor;
    }


    protected void elementToHasAttribute(WebElement element, String attribute, String value) {
        waiter().until(ExpectedConditions.attributeContains(element, attribute, value));
    }
    public void verifyThatElementIsVisible(final WebElement locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public void scrollToElement(WebElement element) {
        getExecutor().executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
