package models.test;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import models.User;
import play.db.jpa.GenericModel;

@Entity
public class User2 extends GenericModel implements java.lang.Comparable {

    @Id
    public String   email;

    public String   password;

    public String   fullname;

    @Embedded
    public Address2 addess;

    public boolean  isAdmin;

    @Override
    public int compareTo(Object o) {
        User u = (User) o;
        return email.compareTo(u.email);
    }

}