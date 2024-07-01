package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;
import utilities.ReusableMethods;

public class CartPage {

    public CartPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    private static final Logger LOG = LogManager.getLogger(CartPage.class);


    @FindBy(xpath = "//input[@name='quantity']")
    WebElement sepetQuantity;

    @FindBy(xpath = "//i[@title='Güncelle']")
    WebElement refreshButton;

    @FindBy(xpath = "//h2[@id='swal2-title']")
    WebElement popup;

    @FindBy(xpath = "//i[@title='Kaldır']")
    WebElement kaldirButton;

    @Step("User increased product quantity")
    public void changeSepetQuantity(int number) {

        String adet = sepetQuantity.getAttribute("value");
        int sayi = Integer.parseInt(adet);
        int sum = sayi + number;

        sepetQuantity.clear();
        sepetQuantity.sendKeys(String.valueOf(sum));
        LOG.info("User changed product quantity");
    }

    @Step("User clicked the refresh button")
    public void refreshClick() {
        refreshButton.click();
        LOG.info("User click refresh button");
    }

    @Step("User confirms cart update")
    public void verifyUpdateCart(String expected) {

        ReusableMethods.waitForVisibility(popup, 5);
        Assert.assertEquals(expected, popup.getText());
        LOG.info("User verify cart update");
    }

    @Step("User deleted product from cart")
    public void removeCart() {

        kaldirButton.click();
        LOG.info("User deletes product from cart");
    }
}
