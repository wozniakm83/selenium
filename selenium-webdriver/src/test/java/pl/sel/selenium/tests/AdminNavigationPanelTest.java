package pl.sel.selenium.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AdminNavigationPanelTest extends TestBase {

    @BeforeMethod
    public void testLoginToLitecartAdmin() throws InterruptedException {
        app.goTo().adminPage();
        app.login().adminLogin(
                app.properties.getProperty("litecart.adminLogin"),
                app.properties.getProperty("litecart.adminPassword")
        );
    }

    @Test
    public void testAdminNavigationPanel() {
        wd.findElement(By.xpath("//li[@id='app-']/a/span[.='Appearence']")).click();
        wd.findElement(By.id("doc-template")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Template"));
        wd.findElement(By.id("doc-logotype")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Logotype"));

        wd.findElement(By.xpath("//li[@id='app-']/a/span[.='Catalog']")).click();
        wd.findElement(By.id("doc-catalog")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Catalog"));
        wd.findElement(By.id("doc-product_groups")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Product Groups"));
        wd.findElement(By.id("doc-option_groups")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Option Groups"));
        wd.findElement(By.id("doc-manufacturers")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Manufacturers"));
        wd.findElement(By.id("doc-suppliers")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Suppliers"));
        wd.findElement(By.id("doc-delivery_statuses")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Delivery Statuses"));
        wd.findElement(By.id("doc-sold_out_statuses")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Sold Out Statuses"));
        wd.findElement(By.id("doc-quantity_units")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Quantity Units"));
        wd.findElement(By.id("doc-csv")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("CSV Import/Export"));

        wd.findElement(By.xpath("//li[@id='app-']/a/span[.='Countries']")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Countries"));

        wd.findElement(By.xpath("//li[@id='app-']/a/span[.='Currencies']")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Currencies"));

        wd.findElement(By.xpath("//li[@id='app-']/a/span[.='Customers']")).click();
        wd.findElement(By.id("doc-customers")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Customers"));
        wd.findElement(By.id("doc-csv")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("CSV Import/Export"));
        wd.findElement(By.id("doc-newsletter")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Newsletter"));

        wd.findElement(By.xpath("//li[@id='app-']/a/span[.='Geo Zones']")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Geo Zones"));

        wd.findElement(By.xpath("//li[@id='app-']/a/span[.='Languages']")).click();
        wd.findElement(By.id("doc-languages")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Languages"));
        wd.findElement(By.id("doc-storage_encoding")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Storage Encoding"));

        wd.findElement(By.xpath("//li[@id='app-']/a/span[.='Modules']")).click();
        wd.findElement(By.id("doc-jobs")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Job Modules"));
        wd.findElement(By.id("doc-customer")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Customer Modules"));
        wd.findElement(By.id("doc-shipping")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Shipping Modules"));
        wd.findElement(By.id("doc-payment")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Payment Modules"));
        wd.findElement(By.id("doc-order_total")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Order Total Modules"));
        wd.findElement(By.id("doc-order_success")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Order Success Modules"));
        wd.findElement(By.id("doc-order_action")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Order Action Modules"));

        wd.findElement(By.xpath("//li[@id='app-']/a/span[.='Orders']")).click();
        wd.findElement(By.id("doc-orders")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Orders"));
        wd.findElement(By.id("doc-order_statuses")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Order Statuses"));

        wd.findElement(By.xpath("//li[@id='app-']/a/span[.='Pages']")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Pages"));

        wd.findElement(By.xpath("//li[@id='app-']/a/span[.='Reports']")).click();
        wd.findElement(By.id("doc-monthly_sales")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Monthly Sales"));
        wd.findElement(By.id("doc-most_sold_products")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Most Sold Products"));
        wd.findElement(By.id("doc-most_shopping_customers")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Most Shopping Customers"));

        wd.findElement(By.xpath("//li[@id='app-']/a/span[.='Settings']")).click();
        wd.findElement(By.id("doc-store_info")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Settings"));
        wd.findElement(By.id("doc-defaults")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Settings"));
        wd.findElement(By.id("doc-general")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Settings"));
        wd.findElement(By.id("doc-listings")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Settings"));
        wd.findElement(By.id("doc-images")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Settings"));
        wd.findElement(By.id("doc-advanced")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Settings"));
        wd.findElement(By.id("doc-checkout")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Settings"));
        wd.findElement(By.id("doc-security")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Settings"));

        wd.findElement(By.xpath("//li[@id='app-']/a/span[.='Slides']")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Slides"));

        wd.findElement(By.xpath("//li[@id='app-']/a/span[.='Tax']")).click();
        wd.findElement(By.id("doc-tax_classes")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Tax Classes"));
        wd.findElement(By.id("doc-tax_rates")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Tax Rates"));

        wd.findElement(By.xpath("//li[@id='app-']/a/span[.='Translations']")).click();
        wd.findElement(By.id("doc-search")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Search Translations"));
        wd.findElement(By.id("doc-scan")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Scan Files For Translations"));
        wd.findElement(By.id("doc-csv")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("CSV Import/Export"));

        wd.findElement(By.xpath("//li[@id='app-']/a/span[.='Users']")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("Users"));

        wd.findElement(By.xpath("//li[@id='app-']/a/span[.='vQmods']")).click();
        assertThat(wd.findElement(By.cssSelector("#content > h1")).getText(), equalTo("vQmods"));
    }
}
