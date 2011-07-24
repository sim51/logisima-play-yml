package models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.jpa.Model;

@Entity
public class Date extends Model {

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

    // @Temporal(TemporalType.TIME)
    // public Calendar cal3;

    @Temporal(TemporalType.TIMESTAMP)
    public Calendar       cal4;
}
