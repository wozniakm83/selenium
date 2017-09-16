package pl.sel.selenium.appmanager;

import org.openqa.selenium.By;

public class SessionHelper extends HelperBase {

    public SessionHelper(ApplicationManager app) throws Exception {
        super(app);
    }

    public void adminLogin(String username, String password) {
        type(By.name("username"), username);
        type(By.name("password"), password);
        if (!wd.findElement(By.name("remember_me")).isSelected()) {
            click(By.name("remember_me"));
        }
        click(By.name("login"));
    }
}
