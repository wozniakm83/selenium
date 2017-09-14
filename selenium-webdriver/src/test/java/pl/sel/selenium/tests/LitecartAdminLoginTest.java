package pl.sel.selenium.tests;

import org.testng.annotations.Test;

public class LitecartAdminLoginTest extends TestBase {

    @Test
    public void testLoginToLitecartAdmin() throws InterruptedException {
        app.goTo().adminPage();
        app.login().adminLogin(
                app.properties.getProperty("litecart.adminLogin"),
                app.properties.getProperty("litecart.adminPassword")
        );
    }
}
