package by.academy.it.entities;


import javax.persistence.Embeddable;

@Embeddable
public class Address {

private String city;
private String postcode;

    public Address() {
    }

    public Address(String city, String postcode) {
        this.city = city;
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
