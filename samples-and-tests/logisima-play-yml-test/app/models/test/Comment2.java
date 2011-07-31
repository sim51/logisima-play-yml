package models.test;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Comment2 extends Model implements java.lang.Comparable {

    @Required
    public String author;

    @Required
    public Date   postedAt;

    @Lob
    @Required
    @MaxSize(10000)
    public String content;

    @ManyToOne
    @Required
    public Post2  post;

    @Override
    public int compareTo(Object o) {
        Comment2 cmt = (Comment2) o;
        return postedAt.compareTo(cmt.postedAt);
    }
}