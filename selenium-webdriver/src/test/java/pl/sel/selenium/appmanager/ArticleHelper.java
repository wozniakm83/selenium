package pl.sel.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pl.sel.selenium.model.ArticleDisplay;

public class ArticleHelper extends HelperBase {

    public ArticleHelper(ApplicationManager app) throws Exception {
        super(app);
    }

    public ArticleDisplay displayOnMainPage(WebElement article) {
        String articleTitle = article.findElement(By.cssSelector("div.name")).getText();
        String regularPriceAmount = article.findElement(By.cssSelector("s.regular-price")).getText();
        String regularPriceColor = article.findElement(By.cssSelector("s.regular-price")).getCssValue("color");
        String regularPriceFontStyle = article.findElement(By.cssSelector("s.regular-price")).getCssValue("text-decoration-line");
        String campaignPriceAmount = article.findElement(By.cssSelector("strong.campaign-price")).getText();
        String campaignPriceColor = article.findElement(By.cssSelector("strong.campaign-price")).getCssValue("color");
        String campaignPriceFontStyle = article.findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-weight");
        return new ArticleDisplay()
                .withTitle(articleTitle)
                .withRegularPriceAmount(regularPriceAmount)
                .withRegularPriceColor(regularPriceColor)
                .withRegularPriceFontStyle(regularPriceFontStyle)
                .withCampaignPriceAmount(campaignPriceAmount)
                .withCampaignPriceColor(campaignPriceColor)
                .withCampaignPriceFontStyle(campaignPriceFontStyle);
    }

    public ArticleDisplay displayOnProductPage(WebElement article) {
        article.click();
        String articleTitle = wd.findElement(By.cssSelector("#box-product > div.content > div.images-wrapper > a > img")).getAttribute("title");
        WebElement price = wd.findElement(By.cssSelector("#box-product > div.content > div.information > div.price-wrapper"));
        String regularPriceAmount = price.findElement(By.cssSelector("s.regular-price")).getText();
        String regularPriceColor = price.findElement(By.cssSelector("s.regular-price")).getCssValue("color");
        String regularPriceFontStyle = price.findElement(By.cssSelector("s.regular-price")).getCssValue("text-decoration-line");
        String campaignPriceAmount = price.findElement(By.cssSelector("strong.campaign-price")).getText();
        String campaignPriceColor = price.findElement(By.cssSelector("strong.campaign-price")).getCssValue("color");
        String campaignPriceFontStyle = price.findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-weight");
        return new ArticleDisplay()
                .withTitle(articleTitle)
                .withRegularPriceAmount(regularPriceAmount)
                .withRegularPriceColor(regularPriceColor)
                .withRegularPriceFontStyle(regularPriceFontStyle)
                .withCampaignPriceAmount(campaignPriceAmount)
                .withCampaignPriceColor(campaignPriceColor)
                .withCampaignPriceFontStyle(campaignPriceFontStyle);
    }
}
