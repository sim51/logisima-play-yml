package models.test;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.jpa.Model;

@Entity
public class Date2 extends Model implements java.lang.Comparable {

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

    @Override
    public int compareTo(Object o) {
        Date2 d = (Date2) o;
        return date1.compareTo(d.date1);
    }
}
