package pl.sel.selenium.tests;

import org.testng.annotations.Test;

public class FirstWebTest extends TestBase {

    @Test
    public void testStartBrowser() {
        wd.get("http://www.google.com/");
    }
}
