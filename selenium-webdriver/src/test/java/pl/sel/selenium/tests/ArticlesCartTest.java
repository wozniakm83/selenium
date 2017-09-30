package pl.sel.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class ArticlesCartTest extends TestBase {

    @Test
    public void testArticlesCart() {

        WebDriverWait wait = new WebDriverWait(wd, 10);
        JavascriptExecutor jse = (JavascriptExecutor)wd;
        int count = 0;
        ArrayList titles = new ArrayList();

        app.goTo().mainPage();
        while(count < 3) {
            int select = new Random().nextInt(5-1) + 1;
            jse.executeScript("window.scrollBy(0,250)", "");
            WebElement article = wd.findElement(By.cssSelector(String.format("#box-most-popular > div > ul > li:nth-child(%s) > a.link", select)));
            if(!titles.contains(article.getAttribute("title"))) {
                titles.add(article.getAttribute("title"));
                article.click();
                if (isElementPresent(By.cssSelector("#box-product select[name='options[Size]']"))) {
                    wd.findElement(By.cssSelector("#box-product select[name='options[Size]']")).sendKeys("Small");
                }
                wd.findElement(By.cssSelector("#box-product input[name='quantity']")).clear();
                wd.findElement(By.cssSelector("#box-product input[name='quantity']")).sendKeys("1");
                wd.findElement(By.cssSelector("#box-product button[type='submit'][name='add_cart_product']")).click();
                count++;
                WebElement quantity = wd.findElement(By.cssSelector("#cart > a.content > span.quantity"));
                wait.until(ExpectedConditions.attributeContains(quantity, "textContent", (String.format("%s", count))));
            }
            jse.executeScript("scroll(0, 0);");
            wd.findElement(By.cssSelector("#logotype-wrapper > a")).click();
        }
        assertThat(wd.findElement(By.cssSelector("#cart > a.content > span.quantity"))
                .getAttribute("textContent"), equalTo(String.format("%s", count)));

        wd.findElement(By.cssSelector("#cart > a.content")).click();
        jse.executeScript("scroll(0, 600);");
        List<WebElement> items = wd.findElements(By.cssSelector("#order_confirmation-wrapper td.item"));
        for(WebElement item : items) {
            jse.executeScript("scroll(0, 0);");
            wd.findElement(By.cssSelector("#box-checkout-cart button[name='remove_cart_item']")).click();
            jse.executeScript("scroll(0, 600);");
            wait.until(ExpectedConditions.stalenessOf(items.get(items.size() - 1)));
            items = wd.findElements(By.cssSelector("#order_confirmation-wrapper td.item"));
        }
        jse.executeScript("scroll(0, 0);");
        wd.findElement(By.cssSelector("#logotype-wrapper > a")).click();
        assertThat(wd.findElement(By.cssSelector("#cart > a.content > span.quantity")).getText(), equalTo(String.format("%s", 0)));
    }
}
