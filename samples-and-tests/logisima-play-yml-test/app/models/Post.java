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

import play.data.validation.MaxSize;
import play.db.jpa.Model;

@Entity
public class Post extends Model {

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

}
