package models.test;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.data.validation.MaxSize;
import play.db.jpa.Model;

@Entity
public class Post2 extends Model {

    public String         title;

    public Date           postedAt;

    @Lob
    @MaxSize(1000)
    public String         content;

    @ManyToOne
    public User2          author;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    public List<Comment2> comments;

    @ManyToMany(cascade = CascadeType.PERSIST)
    public Set<Tag2>      tags;

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
        if (!this.author.equals(post.author)) {
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

}
