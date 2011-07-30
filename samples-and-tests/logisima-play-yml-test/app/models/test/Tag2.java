package models.test;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Tag2 extends Model {

    public String name;

    public int compareTo(Tag2 tag) {
        final int NOT_EQUAL = -1;
        final int EQUAL = 0;

        if (!this.name.equals(tag.name)) {
            return NOT_EQUAL;
        }
        return EQUAL;
    }

}