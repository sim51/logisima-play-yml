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
public class Post2 extends Model implements java.lang.Comparable {

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

    @Override
    public int compareTo(Object o) {
        Post2 p = (Post2) o;
        return postedAt.compareTo(p.postedAt);
    }

}
