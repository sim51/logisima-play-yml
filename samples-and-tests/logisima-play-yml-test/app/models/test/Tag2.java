package models.test;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Tag2 extends Model implements java.lang.Comparable {

    public String name;

    @Override
    public int compareTo(Object o) {
        Tag2 t = (Tag2) o;
        return name.compareTo(t.name);
    }

}