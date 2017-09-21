package pl.sel.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AdminCountriesOrderTest extends TestBase{

    @BeforeMethod
    public void loginToAdminPage() throws InterruptedException {
        adminLogin();
    }

    @Test
    public void testCountriesOrder() {
        wd.findElement(By.cssSelector("#app-:nth-child(3) > a > span.name")).click();
        assertThat(wd.getCurrentUrl(), equalTo(app.properties.getProperty("litecart.adminCountries")));
        List<WebElement> countries = wd.findElements(By.cssSelector("#content > form[name='countries_form'] tr.row"));
        ArrayList countriesList = new ArrayList<>();
        for (int i = 1; i <= countries.size(); i++) {
            String countryName = wd.findElement(
                    By.cssSelector(String.format("tr:nth-child(%s) > td:nth-child(5) > a", i+1))).getAttribute("text");
            countriesList.add(countryName);
            isSorted(countriesList);
            if (wd.findElement(By.cssSelector(String.format("tr:nth-child(%s) > td:nth-child(6)", i+1)))
                    .getText().equals("0")) {
                wd.get(app.properties.getProperty("litecart.adminCountries"));
            } else {
                wd.findElement(By.cssSelector(String.format("tr:nth-child(%s) > td:nth-child(5) > a", i+1))).click();
                List<WebElement> zones = wd.findElements(By.cssSelector(
                        "#table-zones tr > td:nth-child(3) > input[type='hidden']"));
                ArrayList zonesList = new ArrayList<>();
                for (WebElement zone : zones) {
                    String zoneName = zone.getAttribute("value");
                    zonesList.add(zoneName);
                }
                System.out.println(zonesList);
                isSorted(zonesList);
                wd.get(app.properties.getProperty("litecart.adminCountries"));
            }
        }
        System.out.println(countriesList);
    }
}
