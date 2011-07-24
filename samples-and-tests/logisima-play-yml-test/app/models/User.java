package models;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

@Entity
public class User extends GenericModel {

    @Id
    public String  email;

    public String  password;

    public String  fullname;

    @Embedded
    public Address addess;

    public boolean isAdmin;

}