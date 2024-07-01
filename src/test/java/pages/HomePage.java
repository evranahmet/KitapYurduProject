package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class HomePage {

    public HomePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    private static final Logger LOG = LogManager.getLogger(HomePage.class);


    @FindBy(id = "cookiescript_accept")
    WebElement cookieAcceptButton;

    @FindBy(id = "search-input")
    WebElement searchBox;

    @Step("User go to url")
    public void goToUrl(String URL) {

        Driver.getDriver().get(ConfigReader.getProperty(URL));
        LOG.info("User go to " + ConfigReader.getProperty(URL));
    }

    @Step("User verifies homepage")
    public void verifyTitle(String expectedTitle) {

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
        LOG.info("User verify title " + Driver.getDriver().getTitle());
    }

    @Step("User accept to cookies")
    public void cookiesAccept() {

        ReusableMethods.waitForVisibility(cookieAcceptButton, 15);

        if (cookieAcceptButton.isDisplayed()) {
            cookieAcceptButton.click();
            LOG.info("user accept to cookies");
        }
    }

    @Step("User searches for product")
    public void searchProduct(String productName) {

        searchBox.sendKeys(productName + Keys.ENTER);
        LOG.info("User search this product " + productName);
    }
}
