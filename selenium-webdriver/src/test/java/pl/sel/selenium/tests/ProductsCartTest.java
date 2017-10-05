package pl.sel.selenium.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class ProductsCartTest extends TestBase {

    @Test
    public void testArticlesCart() {

        int count = 0;

        app.goTo().mainPage();
        while(count < 3) {
            app.mainpage().selectProduct();
            app.product().addProductToCart();
            count++;
            app.product().waitForCartUpdate(count);
            app.product().returnToMainPage();
        }
        app.mainpage().checkNumberOfProductsInCart(count);

        app.goTo().cartPage();
        List<WebElement> items = app.cart().getListOfItems();
        app.cart().removeAllItemsFromCart(items);
        app.cart().returnToMainPage();
        app.mainpage().checkNumberOfProductsInCart(0);
    }
}
