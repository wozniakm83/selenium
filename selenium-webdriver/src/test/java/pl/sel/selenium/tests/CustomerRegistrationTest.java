package pl.sel.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CustomerRegistrationTest extends TestBase {

    @Test
    public void testCustomerRegistration() {

        app.goTo().userRegistrationPage();
        JavascriptExecutor jse = (JavascriptExecutor)wd;
        long unixTime = System.currentTimeMillis() / 1000L;
        String taxId = String.format("%s", unixTime).substring(0,7);
        String company = "Damage, Inc.";
        String firstname = "firstname";
        String lastname = "lastname";
        String address1 = "address1";
        String address2 = "address2";
        String postcode = String.format("%s", unixTime).substring(5);
        String city = "San Francisco";
        String countrycode = "United States";
        String zonecode = "California";
        String email = String.format("%s@email.com", unixTime);
        String phone = String.format("%s", unixTime);
        String newsletter = "1";
        String password = "password";

        WebElement customerForm = wd.findElement(By.cssSelector("#create-account > div > form"));
        customerForm.findElement(By.cssSelector("input[name='tax_id']")).sendKeys(taxId);
        customerForm.findElement(By.cssSelector("input[name='company']")).sendKeys(company);
        customerForm.findElement(By.cssSelector("input[name='firstname']")).sendKeys(firstname);
        customerForm.findElement(By.cssSelector("input[name='lastname']")).sendKeys(lastname);
        customerForm.findElement(By.cssSelector("input[name='address1']")).sendKeys(address1);
        customerForm.findElement(By.cssSelector("input[name='address2']")).sendKeys(address2);
        customerForm.findElement(By.cssSelector("input[name='postcode']")).sendKeys(postcode);
        customerForm.findElement(By.cssSelector("input[name='city']")).sendKeys(city);
        customerForm.findElement(By.cssSelector("select[name='country_code']")).sendKeys(countrycode);
        customerForm.findElement(By.cssSelector("select[name='zone_code']")).sendKeys(zonecode);
        customerForm.findElement(By.cssSelector("input[name='email']")).sendKeys(email);
        customerForm.findElement(By.cssSelector("input[name='phone']")).sendKeys(phone);
        customerForm.findElement(By.cssSelector("input[name='newsletter']")).sendKeys(newsletter);
        customerForm.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        customerForm.findElement(By.cssSelector("input[name='confirmed_password']")).sendKeys(password);

        jse.executeScript("scroll(0, 500);");
        customerForm.findElement(By.cssSelector("button[name='create_account']")).click();

        wd.findElement(By.cssSelector("#box-account > div > ul > li:nth-child(4) > a")).click();

        wd.findElement(By.cssSelector("#box-account-login input[name='email']")).sendKeys(email);
        wd.findElement(By.cssSelector("#box-account-login input[name='password']")).sendKeys(password);
        wd.findElement(By.cssSelector("#box-account-login button[name='login']")).click();

        wd.findElement(By.cssSelector("#box-account > div > ul > li:nth-child(4) > a")).click();
    }
}
