package pl.sel.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pl.sel.selenium.model.ArticleDisplay;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ArticlePageTest extends TestBase {

    @Test
    public void testArticlePage() {
        app.goTo().mainPage();
        WebElement article = wd.findElement(By.cssSelector("#box-campaigns > div > ul > li > a.link"));
        ArticleDisplay articleDisplayOnMainPage = app.article().displayOnMainPage(article);
        System.out.println(articleDisplayOnMainPage);
        ArticleDisplay articleDisplayOnProductPage = app.article().displayOnProductPage(article);
        System.out.println(articleDisplayOnProductPage);
        assertThat(articleDisplayOnMainPage, equalTo(articleDisplayOnProductPage)); // SHOULD FAIL
    }
}