package models;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    public Integer number;

    public String  street;

    public Integer zip;

    public String  city;

    public String  country;
}
