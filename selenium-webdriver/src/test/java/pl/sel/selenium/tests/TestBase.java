package pl.sel.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pl.sel.selenium.appmanager.ApplicationManager;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver wd;

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
        wd = app.getDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

    protected boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

/*    protected boolean isElementPresent(By locator) {
        try {
            wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return wd.findElements(locator).size() > 0;
        } finally {
            wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        }
    }*/

    protected boolean isElementNotPresent(By locator) {
        try {
            wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            return wd.findElements(locator).size() == 0;
        } finally {
            wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    public void adminLogin() throws InterruptedException {
        app.goTo().adminPage();
        app.login().adminLogin(
                app.properties.getProperty("litecart.adminLogin"),
                app.properties.getProperty("litecart.adminPassword")
        );
    }

    public static <E extends Comparable<E>> boolean isSorted(Iterable<E> collection) {
        E previous = null;
        for (E value : collection) {
            if (previous != null && previous.compareTo(value) > 0)
                return false;
            previous = value;
        }
        return true;
    }

    public String getFilePath(String filepath) {
        File file = new File(filepath);
        String path = file.getAbsolutePath();
        return path;
    }

}
