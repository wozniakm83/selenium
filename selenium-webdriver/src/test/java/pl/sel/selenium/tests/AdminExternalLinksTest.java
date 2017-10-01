package pl.sel.selenium.tests;

import org.openqa.selenium.By;
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

    WebDriverWait wait = new WebDriverWait(wd, 10);

    @Test
    public void testAdminExternalLinks() {
        wd.findElement(By.cssSelector("#app-:nth-child(3) > a > span.name")).click();
        assertThat(wd.getCurrentUrl(), equalTo(app.properties.getProperty("litecart.adminCountries")));
        wd.findElement(By.cssSelector("#content > div > a.button")).click();
        assertThat(wd.getCurrentUrl(), equalTo(app.properties.getProperty("litecart.adminEditCountry")));

        List<WebElement> externalLinks = wd.findElements(By.cssSelector("#content i.fa fa-external-link"));
        for(WebElement externalLink : externalLinks) {
            String mainWindow = wd.getWindowHandle();
            Set<String> oldWindows = wd.getWindowHandles();
            externalLink.click();
            String newWindow = wait.until(thereIsWindowOtherThan(oldWindows));
            wd.switchTo().window(newWindow);
            wd.close();
            wd.switchTo().window(mainWindow);
        }
    }

    public ExpectedCondition<Boolean> thereIsWindowOtherThan(Set<String> windows) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply() {
                Set<String> newWindows = wd.getWindowHandles();
                return newWindows.size() > windows.size();
            }
        };
    }
}
