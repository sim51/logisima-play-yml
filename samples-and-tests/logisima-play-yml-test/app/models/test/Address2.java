package models.test;

import javax.persistence.Embeddable;

@Embeddable
public class Address2 {

    public Integer number;

    public String  street;

    public Integer zip;

    public String  city;

    public String  country;

}
