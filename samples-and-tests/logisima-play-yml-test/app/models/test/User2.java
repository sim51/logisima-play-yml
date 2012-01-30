package models.test;

import java.util.EnumSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import models.Badge;
import models.User;
import play.db.jpa.GenericModel;

@Entity
public class User2 extends GenericModel implements java.lang.Comparable {

    @Id
    public String     email;

    public String     password;

    public String     fullname;

    @Embedded
    public Address2   addess;

    public boolean    isAdmin;

    @ElementCollection
    public Set<Badge> badges = EnumSet.noneOf(Badge.class);

    @Override
    public int compareTo(Object o) {
        User u = (User) o;
        return email.compareTo(u.email);
    }

}
