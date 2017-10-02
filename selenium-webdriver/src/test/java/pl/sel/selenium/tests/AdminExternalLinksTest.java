package pl.sel.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AdminExternalLinksTest extends TestBase{

    @BeforeMethod
    public void loginToAdminPage() throws InterruptedException {
        adminLogin();
    }

    @Test
    public void testAdminExternalLinks() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        JavascriptExecutor jse = (JavascriptExecutor)wd;
        wd.findElement(By.cssSelector("#app-:nth-child(3) > a > span.name")).click();
        assertThat(wd.getCurrentUrl(), equalTo(app.properties.getProperty("litecart.adminCountries")));
        wd.findElement(By.cssSelector("#content > div > a.button")).click();
        assertThat(wd.getCurrentUrl(), equalTo(app.properties.getProperty("litecart.adminEditCountry")));

        List<WebElement> externalLinks = wd.findElements(By.className("fa-external-link"));
        jse.executeScript("window.scrollBy(0,100)", "");
        int count = 0;
        for(WebElement externalLink : externalLinks) {
            String mainWindow = wd.getWindowHandle();
            Set<String> oldWindows = wd.getWindowHandles();
            String url = simplifyUrl(externalLink.findElement(By.xpath("./..")).getAttribute("href"));
            externalLink.click();
            String newWindow = wait.until((ExpectedCondition<String>) wd -> {
                Set<String> openWindows = wd.getWindowHandles();
                openWindows.removeAll(oldWindows);
                return openWindows.size() > 0 ? openWindows.iterator().next() : null;
            });
            count++;
            System.out.println(newWindow);
            wd.switchTo().window(newWindow);
            String currentUrl = simplifyUrl(wd.getCurrentUrl());
            System.out.println(String.format("%s) %s \nExpected: %s \n  Actual: %s", count, newWindow, url, currentUrl));
            //assertThat(currentUrl, equalTo(url));
            wd.close();
            wd.switchTo().window(mainWindow);
        }
    }

    public String simplifyUrl(String url) {
        String newUrl = url.replace("https://", "").replace("http://", "");
        return newUrl;
    }
}
