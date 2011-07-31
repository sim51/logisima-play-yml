package models;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import models.test.Comment2;
import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Comment extends Model implements java.lang.Comparable {

    @Required
    public String         author;

    @Required
    public java.util.Date postedAt;

    @Lob
    @Required
    @MaxSize(10000)
    public String         content;

    @ManyToOne
    @Required
    public Post           post;

    public int compareTo(Comment2 comment) {
        final int NOT_EQUAL = -1;
        final int EQUAL = 0;

        if (!this.author.equals(comment.author)) {
            return NOT_EQUAL;
        }
        if (!this.postedAt.equals(comment.postedAt)) {
            return NOT_EQUAL;
        }
        if (!this.content.equals(comment.content)) {
            return NOT_EQUAL;
        }
        if (post.compareTo(comment.post) != 0) {
            return NOT_EQUAL;
        }
        return EQUAL;
    }

    @Override
    public int compareTo(Object o) {
        Comment cmt = (Comment) o;
        return postedAt.compareTo(cmt.postedAt);
    }

}