package hellojpa;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    private String city;
    private String street;
    private Integer zipcode;

    public Address() {
    }

    public Address(String city, String street, Integer zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }
    public String getStreet() {
        return street;
    }
    public Integer getZipcode() {
        return zipcode;
    }
}
