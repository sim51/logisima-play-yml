package models.test;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

@Entity
public class User2 extends GenericModel {

    @Id
    public String  email;

    public String  password;

    public String  fullname;

    @Embedded
    public Address2 addess;

    public boolean isAdmin;

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
        return EQUAL;
    }
}