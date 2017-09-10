package pl.sel.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FirstWebTest extends TestBase {

    WebDriver wd;

    @Test
    public void testStartBrowser() {
        //app.goTo("http://www.google.com/");
        wd.get("http://www.google.com/");
    }
}
