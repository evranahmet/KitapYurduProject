package pages;

public class AllPage {

    public AllPage() {

    }

    private HomePage homePage;
    private SearchResultPage searchResultPage;
    private ProductDetailsPage productDetailsPage;
    private CartPage cartPage;


    public HomePage homePage() {

        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public SearchResultPage searchResultPage() {

        if (searchResultPage == null) {
            searchResultPage = new SearchResultPage();
        }
        return searchResultPage;
    }

    public ProductDetailsPage productDetailsPage() {

        if (productDetailsPage == null) {
            productDetailsPage = new ProductDetailsPage();
        }
        return productDetailsPage;
    }

    public CartPage cartPage() {

        if (cartPage == null) {
            cartPage = new CartPage();
        }
        return cartPage;
    }
}
