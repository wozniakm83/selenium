package pl.sel.selenium.appmanager;

import org.openqa.selenium.By;
import pl.sel.selenium.model.CustomerData;

public class CustomerHelper extends HelperBase {

    public CustomerHelper(ApplicationManager app) throws Exception {
        super(app);
    }

    public void initCustomerRegistration() { wd.findElement(By.cssSelector("#box-account-login a")).click(); }

    public void fillCustomerForm(CustomerData customerData) {
        type(By.name("tax_id"), customerData.getTaxId());
        type(By.name("company"), customerData.getCompany());
        type(By.name("firstname"), customerData.getFirstname());
        type(By.name("lastname"), customerData.getLastname());
        type(By.name("address1"), customerData.getAddress1());
        type(By.name("address2"), customerData.getAddress2());
        type(By.name("postcode"), customerData.getPostcode());
        type(By.name("city"), customerData.getCity());
        type(By.name("country_code"), customerData.getCountrycode());
        type(By.name("zone_code"), customerData.getZonecode());
        type(By.name("email"), customerData.getEmail());
        type(By.name("phone"), customerData.getPhone());
        type(By.name("newsletter"), customerData.getNewsletter());
        type(By.name("password"), customerData.getPassword());
        type(By.name("password"), customerData.getPassword());
    }

    public void submitCustomerRegistration() {
        wd.findElement(By.cssSelector("#create-account button[name='create_account']")).click();
    }

    public void register(CustomerData customerData) {
        initCustomerRegistration();
        fillCustomerForm(customerData);
        submitCustomerRegistration();
    }


}
