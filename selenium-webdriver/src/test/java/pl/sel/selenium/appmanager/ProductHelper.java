package pl.sel.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.sel.selenium.model.ProductDisplay;

import java.util.concurrent.TimeUnit;

public class ProductHelper extends HelperBase {


    public ProductHelper(ApplicationManager app) throws Exception {
        super(app);
    }

    public void selectSizeIfRequired() {
        if (isElementPresent(By.cssSelector("#box-product select[name='options[Size]']"))) {
            wd.findElement(By.cssSelector("#box-product select[name='options[Size]']")).sendKeys("Small");
        }
    }

    public void enterQuantity() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#box-product input[name='quantity']")));
        wd.findElement(By.cssSelector("#box-product input[name='quantity']")).clear();
        wd.findElement(By.cssSelector("#box-product input[name='quantity']")).sendKeys("1");
    }

    public void addToCart() {
        wd.findElement(By.cssSelector("#box-product button[type='submit'][name='add_cart_product']")).click();
    }

    public void addProductToCart() {
        app.product().enterQuantity();
        app.product().selectSizeIfRequired();
        app.product().addToCart();
    }

    public void waitForCartUpdate(int count) {
        WebElement quantity = wd.findElement(By.cssSelector("#cart > a.content > span.quantity"));
        wait.until(ExpectedConditions.attributeContains(quantity, "textContent", (String.format("%s", count))));
    }

    public void returnToMainPage() {
        app.goTo().pageTop();
        wd.findElement(By.cssSelector("#logotype-wrapper > a")).click();
    }

    public ProductDisplay displayOnMainPage(WebElement product) {
        String productTitle = product.findElement(By.cssSelector("div.name")).getText();
        String regularPriceAmount = product.findElement(By.cssSelector("s.regular-price")).getText();
        String regularPriceColor = product.findElement(By.cssSelector("s.regular-price")).getCssValue("color");
        String regularPriceFontStyle = product.findElement(By.cssSelector("s.regular-price")).getCssValue("text-decoration-line");
        String campaignPriceAmount = product.findElement(By.cssSelector("strong.campaign-price")).getText();
        String campaignPriceColor = product.findElement(By.cssSelector("strong.campaign-price")).getCssValue("color");
        String campaignPriceFontStyle = product.findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-weight");
        return new ProductDisplay()
                .withTitle(productTitle)
                .withRegularPriceAmount(regularPriceAmount)
                .withRegularPriceColor(regularPriceColor)
                .withRegularPriceFontStyle(regularPriceFontStyle)
                .withCampaignPriceAmount(campaignPriceAmount)
                .withCampaignPriceColor(campaignPriceColor)
                .withCampaignPriceFontStyle(campaignPriceFontStyle);
    }

    public ProductDisplay displayOnProductPage(WebElement product) {
        product.click();
        String productTitle = wd.findElement(By.cssSelector("#box-product > div.content > div.images-wrapper > a > img")).getAttribute("title");
        WebElement price = wd.findElement(By.cssSelector("#box-product > div.content > div.information > div.price-wrapper"));
        String regularPriceAmount = price.findElement(By.cssSelector("s.regular-price")).getText();
        String regularPriceColor = price.findElement(By.cssSelector("s.regular-price")).getCssValue("color");
        String regularPriceFontStyle = price.findElement(By.cssSelector("s.regular-price")).getCssValue("text-decoration-line");
        String campaignPriceAmount = price.findElement(By.cssSelector("strong.campaign-price")).getText();
        String campaignPriceColor = price.findElement(By.cssSelector("strong.campaign-price")).getCssValue("color");
        String campaignPriceFontStyle = price.findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-weight");
        return new ProductDisplay()
                .withTitle(productTitle)
                .withRegularPriceAmount(regularPriceAmount)
                .withRegularPriceColor(regularPriceColor)
                .withRegularPriceFontStyle(regularPriceFontStyle)
                .withCampaignPriceAmount(campaignPriceAmount)
                .withCampaignPriceColor(campaignPriceColor)
                .withCampaignPriceFontStyle(campaignPriceFontStyle);
    }
}
