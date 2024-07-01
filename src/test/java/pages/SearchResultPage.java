package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Random;

public class SearchResultPage {

    public SearchResultPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    private static final Logger LOG = LogManager.getLogger(SearchResultPage.class);

    @FindBy(xpath = "//h1[@class='search-heading-title']")
    WebElement resultTitle;

    @FindBy(xpath = "//div[@class='name']")
    List<WebElement> searchBookList;

    @Step("User verify result")
    public void verifySearchResult(String product) {

        Assert.assertTrue(resultTitle.getText().contains(product));
        LOG.info("User verify result " + product);
    }

    @Step("User switches to new page")
    public void clickPage(String pageNumber) {

        WebElement pageElementi = Driver.getDriver().findElement(By.linkText(pageNumber));
        ReusableMethods.clickElementByJS(pageElementi);
        LOG.info("User switches to new page");
    }

    @Step("User verify that he is on the new page")
    public void pageVerify(String text) {

        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(text));
        LOG.info("User verify that he is on the new page");
    }

    @Step("User adds a random product to cart")
    public void randomBookClick() {

        Random rdm = new Random();
        int sayi = rdm.nextInt(searchBookList.size());

        searchBookList.get(sayi).click();
        LOG.info("User adds a random product to cart");
    }
}
