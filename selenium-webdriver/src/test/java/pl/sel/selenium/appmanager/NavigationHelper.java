package pl.sel.selenium.appmanager;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager app) throws Exception {
        super(app);
    }

    public void adminPage() {
        if(isElementPresent(By.tagName("span"))
                && wd.findElement(By.tagName("span")).getText().equals("Appearance")) {
            return;
        }
        wd.get("http://localhost/litecart/admin/");
    }

    public void mainPage() {
        if(isElementPresent(By.tagName("h3"))
                && wd.findElement(By.tagName("h3")).getText().equals("Categories")) {
            return;
        }
        wd.get("http://localhost/litecart/");
    }

    public void userRegistrationPage() {
        app.goTo().mainPage();
/*        if(isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Create Account")) {
            return;
        }*/
        wd.findElement(By.cssSelector("#box-account-login a")).click();
    }

    public void cartPage() {
        app.goTo().mainPage();
        wd.findElement(By.cssSelector("#cart > a.content")).click();
    }

    public void pageTop() {
        jse.executeScript("scroll(0, 0);");
    }
}