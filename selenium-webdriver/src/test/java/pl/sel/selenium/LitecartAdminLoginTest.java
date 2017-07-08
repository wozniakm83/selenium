package pl.sel.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LitecartAdminLoginTest {
    ChromeDriver wd;

    @BeforeMethod
    public void setUp() throws Exception {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

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

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

    public static boolean isAlertPresent(ChromeDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
