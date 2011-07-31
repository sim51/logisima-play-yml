package models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import models.test.Date2;
import play.db.jpa.Model;

@Entity
public class Date extends Model implements java.lang.Comparable {

    public java.util.Date date1;

    @Temporal(TemporalType.DATE)
    public java.util.Date date2;

    @Temporal(TemporalType.TIME)
    public java.util.Date date3;

    @Temporal(TemporalType.TIMESTAMP)
    public java.util.Date date4;

    public Calendar       cal1;

    @Temporal(TemporalType.DATE)
    public Calendar       cal2;

    @Temporal(TemporalType.TIMESTAMP)
    public Calendar       cal4;

    public int compareTo(Date2 date) {
        final int NOT_EQUAL = -1;
        final int EQUAL = 0;

        if (!this.date1.equals(date.date1)) {
            return NOT_EQUAL;
        }
        if (!this.date2.equals(date.date2)) {
            return NOT_EQUAL;
        }
        if (!this.date3.equals(date.date3)) {
            return NOT_EQUAL;
        }
        if (!this.date4.equals(date.date4)) {
            return NOT_EQUAL;
        }
        if (!this.cal1.equals(date.cal1)) {
            return NOT_EQUAL;
        }
        if (!this.cal2.equals(date.cal2)) {
            return NOT_EQUAL;
        }
        if (!this.cal4.equals(date.cal4)) {
            return NOT_EQUAL;
        }
        return EQUAL;
    }

    @Override
    public int compareTo(Object o) {
        models.Date date = (Date) o;
        date1.compareTo(date.date1);
        return 0;
    }

}
