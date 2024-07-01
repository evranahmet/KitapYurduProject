package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.AllPage;
import utilities.Driver;

@Epic("Regression Tests")
@Feature("Cart Tests")
public class KitapYurdu {

    @Description("Test Description: Scenario where the user adds and removes items from the cart.")
    @Story("Test to add product to cart")
    @Test(priority = 1, description = "Scenario where the user adds and removes items from the cart.")
    public void kitapYurduTest() {

        AllPage allPage = new AllPage();

        allPage.homePage().goToUrl("url");

        allPage.homePage().verifyTitle("Kitapyurdu, Kitapla buluşmanın en kolay yolu");

        allPage.homePage().cookiesAccept();

        allPage.homePage().searchProduct("roman");

        allPage.searchResultPage().verifySearchResult("roman");

        allPage.searchResultPage().clickPage("2");

        allPage.searchResultPage().pageVerify("page=2");

        allPage.searchResultPage().randomBookClick();

        allPage.productDetailsPage().sepetCountVerify("0");

        allPage.productDetailsPage().clickSepeteEkle();

        allPage.productDetailsPage().sepetCountVerify("1");

        allPage.productDetailsPage().sepeteGit();

        allPage.cartPage().changeSepetQuantity(1);

        allPage.cartPage().refreshClick();

        allPage.cartPage().verifyUpdateCart("Sepetiniz güncelleniyor!");

        allPage.cartPage().removeCart();

        allPage.productDetailsPage().sepetCountVerify("0");

        Driver.closeDriver();
    }
}
