package pl.sel.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pl.sel.selenium.model.ProductDisplay;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ProductPageTest extends TestBase {

    @Test
    public void testProductPage() {
        app.goTo().mainPage();
        JavascriptExecutor jse = (JavascriptExecutor)wd;
        WebElement product = wd.findElement(By.cssSelector("#box-campaigns > div > ul > li > a.link"));
        ProductDisplay productDisplayOnMainPage = app.article().displayOnMainPage(product);
        System.out.println(productDisplayOnMainPage);
        jse.executeScript("scroll(0, 500);");
        ProductDisplay productDisplayOnProductPage = app.article().displayOnProductPage(product);
        System.out.println(productDisplayOnProductPage);
        assertThat(productDisplayOnMainPage, equalTo(productDisplayOnProductPage)); // SHOULD FAIL
    }
}