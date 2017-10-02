package pl.sel.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class AdminLogsAndMessagesCheckTest extends TestBase {

    @BeforeMethod
    public void loginToAdminPage() throws InterruptedException {
        adminLogin();
    }

    @Test
    public void testAdminLogsAndMessagesCheck() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        String openLinkInNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
        wd.findElement(By.cssSelector("#app-:nth-child(2) > a > span.name")).click();
        wd.findElement(By.cssSelector("#doc-catalog > a")).click();
        wd.findElement(By.linkText("Rubber Ducks")).click();
        List<WebElement> products = wd.findElements(By.cssSelector(
                "#content td:nth-child(3) > a[href*='&doc=edit_product'][href*='&product_id=']")
        );
        for(WebElement product : products) {
            String mainWindow = wd.getWindowHandle();
            Set<String> oldWindows = wd.getWindowHandles();
            product.sendKeys(openLinkInNewTab);
            String newWindow = wait.until((ExpectedCondition<String>) wd -> {
                Set<String> openWindows = wd.getWindowHandles();
                openWindows.removeAll(oldWindows);
                return openWindows.size() > 0 ? openWindows.iterator().next() : null;
            });
            wd.switchTo().window(newWindow);
            for (LogEntry l : wd.manage().logs().get("browser").getAll()) {
                System.out.println(l);
            }
            wd.close();
            wd.switchTo().window(mainWindow);
        }
    }
}
