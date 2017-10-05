package pl.sel.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class MainPageHelper extends HelperBase {

    public MainPageHelper(ApplicationManager app) throws Exception {
        super(app);
    }

    ArrayList titles = new ArrayList();

    public void selectProduct() {
        int selected = 0;
        while(selected != 1) {
            int select = new Random().nextInt(5 - 0) + 1;
            jse.executeScript("scroll(0, 250);");
            WebElement article = wd.findElement(By.cssSelector(String.format("#box-most-popular > div > ul > li:nth-child(%s) > a.link", select)));
            if (!titles.contains(article.getAttribute("title"))) {
                titles.add(article.getAttribute("title"));
                article.click();
                selected = 1;
            }
        }
    }

    public void checkNumberOfProductsInCart(int count) {
        assertThat(wd.findElement(By.cssSelector("#cart > a.content > span.quantity"))
                .getAttribute("textContent"), equalTo(String.format("%s", count)));
    }

    public void checkIfCartIsEmpty() {
        assertThat(wd.findElement(By.cssSelector("#cart > a.content > span.quantity"))
                .getText(), equalTo(String.format("%s", 0)));
    }
}
