package models;

import java.util.EnumSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import models.test.User2;
import play.db.jpa.GenericModel;

@Entity
public class User extends GenericModel implements java.lang.Comparable {

    public static final String MENTION_FORMAT = "$LINKIT${%s}";

    @Id
    public String              email;

    public String              password;

    public String              fullname;

    @Embedded
    public Address             addess;

    public boolean             isAdmin;

    @ElementCollection
    public Set<Badge>          badges         = EnumSet.noneOf(Badge.class);

    public int compareTo(User2 user) {
        final int NOT_EQUAL = -1;
        final int EQUAL = 0;
        if (!this.email.equals(user.email)) {
            return NOT_EQUAL;
        }
        if (!this.password.equals(user.password)) {
            return NOT_EQUAL;
        }
        if (!this.fullname.equals(user.fullname)) {
            return NOT_EQUAL;
        }
        if (this.isAdmin != user.isAdmin) {
            return NOT_EQUAL;
        }
        if (this.addess.compareTo(user.addess) != 0) {
            return NOT_EQUAL;
        }
        if (this.badges.size() != user.badges.size()) {
            return NOT_EQUAL;
        }
        return EQUAL;
    }

    @Override
    public int compareTo(Object o) {
        User u = (User) o;
        return email.compareTo(u.email);
    }
}
