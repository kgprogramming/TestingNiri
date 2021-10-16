package NIRI.Pages;



import LocalUtils.Annotations.WebElementLocator;
import LocalUtils.Annotations.WebElementLocatorFactory;
import NIRI.SiteTools.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AboutUsPage extends BaseClass {

    // Web elements
    @WebElementLocator(webDesktop = "//a[@href='mailto:contact@niri-ic.com']")
    private static WebElement locatorOfMail() {
        return getDriver().findElement(By.xpath(new WebElementLocatorFactory().getLocator(AboutUsPage.class, "locatorOfMail")));
    }
    @WebElementLocator(webDesktop = " //li[@class='email-icon'][2]")
    private static WebElement locatorOfMobilePhone() {
        return getDriver().findElement(By.xpath(new WebElementLocatorFactory().getLocator(AboutUsPage.class, "locatorOfMobilePhone")));
    }

    public boolean regexForEmail(String regex) {
        scrollToElement(locatorOfMail());
        String name = locatorOfMail().getText();
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();

    }
        public boolean regexForMobilePhone(String regex) {
            scrollToElement(locatorOfMail());
            String telephone=locatorOfMobilePhone().getText();
            Pattern patter=Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
            Matcher matche = patter.matcher(telephone);
            return matche.matches();
}

    // Actions


}
