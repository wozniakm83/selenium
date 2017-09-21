package pl.sel.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AdminGeoZonesOrderTest extends TestBase{

    @BeforeMethod
    public void loginToAdminPage() throws InterruptedException {
        adminLogin();
    }

    @Test
    public void testCountriesOrder() {
        wd.findElement(By.cssSelector("#app-:nth-child(6) > a > span.name")).click();
        assertThat(wd.getCurrentUrl(), equalTo(app.properties.getProperty("litecart.adminGeozones")));
        List<WebElement> geozones = wd.findElements(By.cssSelector("#content > form[name='geo_zones_form'] tr.row"));
        for (int i = 1; i <= geozones.size(); i++) {
            WebElement findGeozone = wd.findElement(By.cssSelector(String.format("tr:nth-child(%s) > td:nth-child(3) > a", i + 1)));
            String geozone = findGeozone.getText();
            findGeozone.click();
            String name = wd.findElement(By.cssSelector("#table-zones tr > td:nth-child(2) > span")).getAttribute("textContent");
            if (geozone.contains(name)) {
                List<WebElement> zones = wd.findElements(By.cssSelector("#table-zones tr > td:nth-child(3) > select option:checked"));
                ArrayList zonesList = new ArrayList<>();
                getNamesList(zones, zonesList);
                System.out.println(zonesList);
                isSorted(zonesList);
            } else {
                List<WebElement> countries = wd.findElements(By.cssSelector("#table-zones tr > td:nth-child(2) > span"));
                ArrayList countriesList = new ArrayList<>();
                getNamesList(countries, countriesList);
                System.out.println(countriesList);
                isSorted(countriesList);
            }
            wd.get(app.properties.getProperty("litecart.adminGeozones"));
        }
    }

    public void getNamesList(List<WebElement> items, ArrayList list) {
        for (WebElement item : items) {
            String name = item.getText();
            list.add(name);
        }
    }
}
