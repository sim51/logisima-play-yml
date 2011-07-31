package models;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import models.test.Post2;
import play.data.validation.MaxSize;
import play.db.jpa.Model;

@Entity
public class Post extends Model implements java.lang.Comparable {

    public String        title;

    public Date          postedAt;

    @Lob
    @MaxSize(1000)
    public String        content;

    @ManyToOne
    public User          author;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    public List<Comment> comments;

    @ManyToMany(cascade = CascadeType.PERSIST)
    public Set<Tag>      tags;

    public int compareTo(Post2 post) {
        final int NOT_EQUAL = -1;
        final int EQUAL = 0;

        if (!this.title.equals(post.title)) {
            return NOT_EQUAL;
        }
        if (!this.postedAt.equals(post.postedAt)) {
            return NOT_EQUAL;
        }
        if (!this.content.equals(post.content)) {
            return NOT_EQUAL;
        }
        if (this.author.compareTo(post.author) != 0) {
            return NOT_EQUAL;
        }
        if (this.comments.size() != post.comments.size()) {
            return NOT_EQUAL;
        }
        if (this.tags.size() != post.tags.size()) {
            return NOT_EQUAL;
        }
        return EQUAL;
    }

    @Override
    public int compareTo(Object o) {
        Post post = (Post) o;
        return postedAt.compareTo(post.postedAt);
    }

}
