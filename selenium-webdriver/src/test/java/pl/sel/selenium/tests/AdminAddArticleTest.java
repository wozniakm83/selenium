package pl.sel.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AdminAddArticleTest extends TestBase {

    @BeforeMethod
    public void loginToAdminPage() throws InterruptedException {
        adminLogin();
    }

    @Test
    public void testAddArticle() throws InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor)wd;
        long unixTime = System.currentTimeMillis() / 1000L;
        String productName = String.format("product_name_%s", unixTime);

        wd.findElement(By.cssSelector("#app-:nth-child(2) > a > span.name")).click();
        wd.findElement(By.cssSelector("#content > div:nth-child(2) > a:nth-child(2)")).click();

        wd.findElement(By.cssSelector("#content a[href='#tab-general']")).click();
        WebElement generalTab = wd.findElement(By.cssSelector("#tab-general"));
        if (!generalTab.findElement(By.cssSelector("input[type='radio'][value='1']")).isSelected()) {
            generalTab.findElement(By.cssSelector("input[type='radio'][value='1']")).click();
        }
        generalTab.findElement(By.cssSelector("input[name='name[en]']")).sendKeys(productName);
        generalTab.findElement(By.cssSelector("input[name='code']")).sendKeys("code");
        List<WebElement> categories = generalTab.findElements(By.cssSelector("input[name='categories[]']"));
        for (WebElement category : categories) {
            if (category.getAttribute("data-name").equals("Rubber Ducks") && !category.isSelected()) {
                category.click();
            } else if(category.isSelected()) {
                category.click();
            }
        }
        generalTab.findElement(By.cssSelector("select[name='default_category_id']")).sendKeys("Rubber Ducks");
        List<WebElement> productGroups = generalTab.findElements(By.cssSelector("input[name='product_groups[]']"));
        for (WebElement productGroup : productGroups) {
            if (!productGroup.isSelected()) {
                productGroup.click();
            }
        }
        generalTab.findElement(By.cssSelector("input[name='quantity']")).clear();
        generalTab.findElement(By.cssSelector("input[name='quantity']")).sendKeys("12.00");
        generalTab.findElement(By.cssSelector("select[name='quantity_unit_id']")).sendKeys("pcs");
        generalTab.findElement(By.cssSelector("select[name='delivery_status_id']")).sendKeys("3-5 days");
        generalTab.findElement(By.cssSelector("select[name='sold_out_status_id']")).sendKeys("Temporary Sold Out");
        generalTab.findElement(By.cssSelector("input[name='new_images[]']"))
                .sendKeys(getFilePath(app.properties.getProperty("product.defaultImage")));
        generalTab.findElement(By.cssSelector("input[name='date_valid_from']"))
                .sendKeys(Keys.HOME + "2018" + Keys.TAB + "0101");
        generalTab.findElement(By.cssSelector("input[name='date_valid_to']"))
                .sendKeys(Keys.HOME + "2019" + Keys.TAB + "0101");
        jse.executeScript("scroll(0, 0);");

        wd.findElement(By.cssSelector("#content a[href='#tab-information']")).click();
        WebElement informationTab = wd.findElement(By.cssSelector("#tab-information"));
        informationTab.findElement(By.cssSelector("select[name='manufacturer_id']")).sendKeys("ACME Corp.");
        informationTab.findElement(By.cssSelector("input[name='keywords']")).sendKeys("keywords");
        informationTab.findElement(By.cssSelector("input[name='short_description[en]']")).sendKeys("short description");
        informationTab.findElement(By.cssSelector("div.trumbowyg-editor")).sendKeys(Keys.HOME + "description");
        informationTab.findElement(By.cssSelector("input[name='head_title[en]']")).sendKeys("head title");
        informationTab.findElement(By.cssSelector("input[name='meta_description[en]']")).sendKeys("meta description");
        jse.executeScript("scroll(0, 0);");

        wd.findElement(By.cssSelector("#content a[href='#tab-prices']")).click();
        WebElement pricesTab = wd.findElement(By.cssSelector("#tab-prices"));
        pricesTab.findElement(By.cssSelector("input[name='purchase_price']")).clear();
        pricesTab.findElement(By.cssSelector("input[name='purchase_price']")).sendKeys(Keys.HOME + "12,34");
        pricesTab.findElement(By.cssSelector("select[name='purchase_price_currency_code']")).sendKeys("US Dollars");
        pricesTab.findElement(By.cssSelector("input[name='prices[USD]']")).sendKeys("12,34");
        pricesTab.findElement(By.cssSelector("input[name='gross_prices[USD]']")).sendKeys("13,45");
        pricesTab.findElement(By.cssSelector("input[name='prices[EUR]']")).sendKeys("13,45");
        pricesTab.findElement(By.cssSelector("input[name='gross_prices[EUR]']")).sendKeys("13,45");

        pricesTab.findElement(By.cssSelector("#add-campaign > i")).click();
        pricesTab.findElement(By.cssSelector("input[name='campaigns[new_1][start_date]']"))
                .sendKeys(Keys.HOME + "2018" + Keys.TAB + "0101 00:00");
        pricesTab.findElement(By.cssSelector("input[name='campaigns[new_1][end_date]']"))
                .sendKeys(Keys.HOME + "2019" + Keys.TAB + "0101 00:00");
        pricesTab.findElement(By.cssSelector("input[name='campaigns[new_1][percentage]']")).clear();
        pricesTab.findElement(By.cssSelector("input[name='campaigns[new_1][percentage]']")).sendKeys("30,00");
        //pricesTab.findElement(By.cssSelector("input[name='campaigns[new_1][USD]']")).sendKeys("10,00");
        //pricesTab.findElement(By.cssSelector("input[name='campaigns[new_1][EUR]']")).sendKeys("10,00");

        wd.findElement(By.xpath("//*[@id='content']/form/p/span/button[@name='save']")).click();

        wd.findElement(By.cssSelector("#doc-catalog > a")).click();
        wd.findElement(By.linkText("Rubber Ducks")).click();
        if (!isElementPresent(By.linkText(productName))) {
            System.out.println("Product not found");
        }
        assertThat(isElementPresent(By.linkText(productName)), equalTo(true));
    }
}


