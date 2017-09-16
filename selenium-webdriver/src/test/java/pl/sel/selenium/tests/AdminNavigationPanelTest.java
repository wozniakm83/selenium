package pl.sel.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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
        List<WebElement> elements = wd.findElements(By.id("app-"));
        for (int i=1; i<=elements.size(); i++){
            elements = wd.findElements(By.id("app-"));
            elements.get(i-1).click();
            if(isElementPresent(By.cssSelector("#app- > ul > li"))) {
                List<WebElement> subelements = wd.findElements(By.cssSelector("#app- > ul > li"));
                for (int n=1; n<=subelements.size(); n++) {
                    subelements = wd.findElements(By.cssSelector("#app- > ul > li"));
                    subelements.get(n-1).click();
                    System.out.println(wd.findElement(By.cssSelector("#content > h1")).getText());
                }
            } else {
                System.out.println(wd.findElement(By.cssSelector("#content > h1")).getText());
            }
        }
    }
}
