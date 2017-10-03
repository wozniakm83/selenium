package pl.sel.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AdminNavigationPanelTest extends TestBase {

    @BeforeMethod
    public void loginToAdminPage() throws InterruptedException {
        adminLogin();
    }

    @Test
    public void testAdminNavigationPanel() {
        JavascriptExecutor jse = (JavascriptExecutor)wd;
        List<WebElement> elements = wd.findElements(By.id("app-"));
        for (int i = 1; i <= elements.size(); i++) {
            jse.executeScript(String.format("scroll(0, %s);", i*38));
            elements = wd.findElements(By.id("app-"));
            elements.get(i - 1).click();
            if (isElementPresent(By.cssSelector("#app- > ul > li"))) {
                List<WebElement> subelements = wd.findElements(By.cssSelector("#app- > ul > li"));
                for (int n = 1; n <= subelements.size(); n++) {
                    jse.executeScript(String.format("window.scrollBy(0,%s)", i*38+n*25), "");
                    subelements = wd.findElements(By.cssSelector("#app- > ul > li"));
                    subelements.get(n - 1).click();
                    checkHeaderIfAvailable();
                }
            } else {
                checkHeaderIfAvailable();
            }
        }
    }
    private void checkHeaderIfAvailable() {
        if (wd.findElement(By.cssSelector("#content > h1")).isDisplayed()) {
            System.out.println(wd.findElement(By.cssSelector("#content > h1")).getText());
        } else {
            System.out.println("Header not displayed");
        }
    }
}
