package NIRI.Pages;

import LocalUtils.Annotations.WebElementLocator;
import LocalUtils.Annotations.WebElementLocatorFactory;
import NIRI.SiteTools.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

public class BlogPage extends BaseClass {

    // Web elements
    @WebElementLocator(webDesktop = "//article[@class='blog-post-item']/header")
    private static List<WebElement> textFromElementsHeader() {
        return getDriver().findElements(By.xpath(new WebElementLocatorFactory().getLocator(BlogPage.class, "textFromElementsHeader")));
    }

    @WebElementLocator(webDesktop = "//div[@class='pagination']/*")
    private static List<WebElement> allElementsFromPagination() {
    return getDriver().findElements(By.xpath(new WebElementLocatorFactory().getLocator(BlogPage.class, "allElementsFromPagination")));
    }
    @WebElementLocator(webDesktop = "//div[@class='pagination']/a[2]")
    private static WebElement buttonNextOnPagination() {
        return getDriver().findElement(By.xpath(new WebElementLocatorFactory().getLocator(BlogPage.class, "buttonNextOnPagination")));
    }
    // Actions
    public int allPostFromBlogPage() {
        return textFromElementsHeader().size();
    }

    public boolean clickOnPaginationAsLongAsButtonNextExist(){
        getDriver().navigate().back();
        List<WebElement>list= allElementsFromPagination();
        List<String> names = new ArrayList<String>();
        for (WebElement nameEle : list){
            names.add(nameEle.getText());
            System.out.println(names);
        }
        if(list .size()>0){
            for (WebElement webElement : list) {
                webElement.click();
            }
            return true;
        }
        else {
        return false;
        }
    }

    public List textFromPage1() throws InterruptedException {
        List<WebElement> elements=textFromElementsHeader();
        List<String> txt = new ArrayList<>();
        for (WebElement nameEle : elements) {
            txt.add(nameEle.getText());
        }
        Thread.sleep(2000);
        System.out.println(txt);
        return txt;
    }
    public List textFromPage2() throws InterruptedException {
        buttonNextOnPagination().click();
        Thread.sleep(2000);
        List<WebElement> headerText = textFromElementsHeader();
        List<String> text = new ArrayList<>();
        for (WebElement nameEle1 : headerText) {
            text.add(nameEle1.getText());
        }
        System.out.println(text);
        return text;
    }
public boolean isItTextEqualsFromPageOne() throws InterruptedException {
    Thread.sleep(2000);
    if (textFromPage1().equals(textFromPage2())){
            System.out.println("Text is same");
            return false;
        }
        else {
            System.out.println("Text is different");
            return true;
        }
}
}