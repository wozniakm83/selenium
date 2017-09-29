package pl.sel.selenium.model;

public class CustomerData {

    private String taxId;
    private String company;
    private String firstname;
    private String lastname;
    private String address1;
    private String address2;
    private String postcode;
    private String city;
    private String countrycode;
    private String zonecode;
    private String email;
    private String phone;
    private String newsletter;
    private String password;


    public CustomerData withTaxId(String taxId) {
        this.taxId = taxId;
        return this;
    }

    public CustomerData withCompany(String company) {
        this.company = company;
        return this;
    }

    public CustomerData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public CustomerData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public CustomerData withAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public CustomerData withAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public CustomerData withPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public CustomerData withCity(String city) {
        this.city = city;
        return this;
    }

    public CustomerData withCountrycode(String countrycode) {
        this.countrycode = countrycode;
        return this;
    }

    public CustomerData withZonecode(String zonecode) {
        this.zonecode = zonecode;
        return this;
    }

    public CustomerData withEmail(String email) {
        this.email = email;
        return this;
    }

    public CustomerData withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public CustomerData withNewsletter(String newsletter) {
        this.newsletter = newsletter;
        return this;
    }

    public CustomerData withPassword(String password) {
        this.password = password;
        return this;
    }


    public String getTaxId() { return taxId; }

    public String getCompany() { return company; }

    public String getFirstname() { return firstname; }

    public String getLastname() { return lastname; }

    public String getAddress1() { return address1; }

    public String getAddress2() { return address2; }

    public String getPostcode() { return postcode; }

    public String getCity() { return city; }

    public String getCountrycode() { return countrycode; }

    public String getZonecode() { return zonecode; }

    public String getEmail() { return email; }

    public String getPhone() { return phone; }

    public String getNewsletter() { return newsletter; }

    public String getPassword() { return password; }

    @Override
    public String toString() {
        return "CustomerData{" +
                "taxId='" + taxId + '\'' +
                ", company='" + company + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", countrycode='" + countrycode + '\'' +
                ", zonecode='" + zonecode + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", newsletter='" + newsletter + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerData that = (CustomerData) o;

        if (taxId != null ? !taxId.equals(that.taxId) : that.taxId != null) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (address1 != null ? !address1.equals(that.address1) : that.address1 != null) return false;
        if (address2 != null ? !address2.equals(that.address2) : that.address2 != null) return false;
        if (postcode != null ? !postcode.equals(that.postcode) : that.postcode != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (countrycode != null ? !countrycode.equals(that.countrycode) : that.countrycode != null) return false;
        if (zonecode != null ? !zonecode.equals(that.zonecode) : that.zonecode != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (newsletter != null ? !newsletter.equals(that.newsletter) : that.newsletter != null) return false;
        return password != null ? password.equals(that.password) : that.password == null;
    }

    @Override
    public int hashCode() {
        int result = taxId != null ? taxId.hashCode() : 0;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (address1 != null ? address1.hashCode() : 0);
        result = 31 * result + (address2 != null ? address2.hashCode() : 0);
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (countrycode != null ? countrycode.hashCode() : 0);
        result = 31 * result + (zonecode != null ? zonecode.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (newsletter != null ? newsletter.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
