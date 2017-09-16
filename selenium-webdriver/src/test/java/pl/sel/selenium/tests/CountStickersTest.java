package pl.sel.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CountStickersTest extends TestBase {

    @Test
    public void testCountStickers() {
        app.goTo().mainPage();
        List<WebElement> articles = wd.findElements(By.cssSelector("div.content div > ul a.link"));
        for (WebElement article : articles) {
            List<WebElement> stickers = article.findElements(
                    By.cssSelector("div.image-wrapper > div[class='sticker sale'"));
            if (stickers.size() > 0) {
                assertThat(stickers.size(), equalTo(1));
            }
            System.out.println(String.format("Number of stickers: %s", stickers.size()));
        }
    }
}