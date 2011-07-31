package models;

import javax.persistence.Embeddable;

import models.test.Address2;

@Embeddable
public class Address {

    public Integer number;

    public String  street;

    public Integer zip;

    public String  city;

    public String  country;

    public int compareTo(Address2 adr) {
        final int NOT_EQUAL = -1;
        final int EQUAL = 0;

        if (!this.number.equals(adr.number)) {
            return NOT_EQUAL;
        }
        if (!this.street.equals(adr.street)) {
            return NOT_EQUAL;
        }
        if (!this.zip.equals(adr.zip)) {
            return NOT_EQUAL;
        }
        if (!this.city.equals(adr.city)) {
            return NOT_EQUAL;
        }
        if (!this.country.equals(adr.country)) {
            return NOT_EQUAL;
        }
        return EQUAL;
    }
}
