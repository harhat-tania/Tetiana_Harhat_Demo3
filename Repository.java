package testAutomation;

public class Repository {
    public Repository(String firstname, String lastname,
          String email, String telephone, String fax, String company,
          String addressMain, String addressAdditional,
          String city, String postCode, String country, String state,
          String password, boolean subscribe) {
//      this.firstname = firstname;
      this.lastname = lastname;
      this.email = email;
      this.telephone = telephone;
     this.fax = fax;
      this.company = company;
     this.addressMain = addressMain;
      this.addressAdditional = addressAdditional;
      this.city = city;
      this.postCode = postCode;
      this.country = country;
      this.state = state;
      this.password = password;
      this.subscribe = subscribe;
  }
    public String getFirstname(String firstname) {
	this.firstname = firstname;
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getFax() {
        return fax;
    }

    public String getCompany() {
        return company;
    }

    public String getAddressMain() {
        return addressMain;
    }

    public String getAddressAdditional() {
        return addressAdditional;
    }

    public String getCity() {
        return city;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getPassword() {
        return password;
    }

    public boolean isSubscribe() {
        return subscribe;
    }
    
}

}
