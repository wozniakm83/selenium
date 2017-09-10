package pl.sel.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LitecartAdminLoginTest extends TestBase {

    WebDriver wd;

    @Test
    public void testLoginToLitecartAdmin() {
        wd.get("http://localhost/litecart/admin");
        wd.findElement(By.cssSelector("a[href='http://localhost/litecart/en/'")).click();
        wd.get("http://localhost/litecart/admin/");
        wd.findElement(By.name("username")).sendKeys("admin");
        wd.findElement(By.name("password")).sendKeys("admin");
        if (!wd.findElement(By.name("remember_me")).isSelected()) {
            wd.findElement(By.name("remember_me")).click();
        }
        wd.findElement(By.name("login")).click();
    }
}
