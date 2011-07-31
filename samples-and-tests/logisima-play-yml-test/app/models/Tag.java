package models;

import javax.persistence.Entity;

import models.test.Tag2;
import play.db.jpa.Model;

@Entity
public class Tag extends Model implements java.lang.Comparable {

    public String name;

    public int compareTo(Tag2 tag) {
        final int NOT_EQUAL = -1;
        final int EQUAL = 0;

        if (!this.name.equals(tag.name)) {
            return NOT_EQUAL;
        }
        return EQUAL;
    }

    @Override
    public int compareTo(Object o) {
        Tag t = (Tag) o;
        return name.compareTo(t.name);
    }

}