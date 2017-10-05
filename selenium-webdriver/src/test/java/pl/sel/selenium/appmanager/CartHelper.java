package pl.sel.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CartHelper extends HelperBase {

    public CartHelper(ApplicationManager app) throws Exception {
        super(app);
    }

    public void checkNumberOfProductsInCart(int count) {
        assertThat(wd.findElement(By.cssSelector("#cart > a.content > span.quantity"))
                .getAttribute("textContent"), equalTo(String.format("%s", count)));
    }

    public List<WebElement> getListOfItems() {
        jse.executeScript("scroll(0, 600);");
        List<WebElement> items = wd.findElements(By.cssSelector("#order_confirmation-wrapper td.item"));
        return items;
    }

    public void removeItemFromCart() {
        app.goTo().pageTop();
        wd.findElement(By.cssSelector("#box-checkout-cart button[name='remove_cart_item']")).click();
    }

    public void waitForCartRefreshAfterRemoval(List<WebElement> items) {
        jse.executeScript("scroll(0, 600);");
        wait.until(ExpectedConditions.stalenessOf(items.get(items.size() - 1)));
    }

    public void removeAllItemsFromCart(List<WebElement> items) {
        for(WebElement item : items) {
            app.cart().removeItemFromCart();
            app.cart().waitForCartRefreshAfterRemoval(items);
            items = app.cart().getListOfItems();
        }
    }

    public void returnToMainPage() {
        app.goTo().pageTop();
        wd.findElement(By.cssSelector("#logotype-wrapper > a")).click();
    }
}