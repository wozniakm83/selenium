package pl.sel.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LitecartAdminLoginTest {

    WebDriver wd;
    WebDriverWait wait;

    /*@BeforeMethod(enabled=false)
    public void setUp() throws Exception {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }*/

    @BeforeMethod(enabled=true)
    public void startChrome() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        options.addArguments("start-maximized");
        wd = new ChromeDriver(options);
        System.out.println(((HasCapabilities) wd).getCapabilities());
        wait = new WebDriverWait(wd, 10);
    }

    @BeforeMethod(enabled=false)
    public void startIExplorer() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
        wd = new InternetExplorerDriver(caps);
        System.out.println(((HasCapabilities) wd).getCapabilities());
        wait = new WebDriverWait(wd, 10);
    }

    @BeforeMethod(enabled=false)
    public void startFirefoxOld() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(FirefoxDriver.MARIONETTE, false);
        wd = new FirefoxDriver(caps);
        System.out.println(((HasCapabilities) wd).getCapabilities());
        wait = new WebDriverWait(wd, 10);
    }

    @BeforeMethod(enabled=false)
    public void startFirefoxNew() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(FirefoxDriver.MARIONETTE, true);
        wd = new FirefoxDriver(caps);
        System.out.println(((HasCapabilities) wd).getCapabilities());
        wait = new WebDriverWait(wd, 10);
    }

    @BeforeMethod(enabled=false)
    public void startFirefoxNightly() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(FirefoxDriver.MARIONETTE, true);
        wd = new FirefoxDriver(
                new FirefoxBinary(new File("C:\\Program Files\\Nightly\\firefox.exe")),
                new FirefoxProfile(), caps);
        System.out.println(((HasCapabilities) wd).getCapabilities());
        wait = new WebDriverWait(wd, 10);
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
        wd = null;
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
