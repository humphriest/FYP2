package entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

@NamedQueries({
        @NamedQuery(name = "comment.findAll", query = "select c from Comment c")
})

@Entity
@XmlRootElement
public class Comment {

    public Comment(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String body;
    private Date timestamp;
    private int rating;

    @ManyToOne
    private User user;

    @ManyToOne
    private StockItem item;

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @XmlElement
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @XmlElement
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @XmlElement
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @XmlElement
    public StockItem getItem() {
        return item;
    }

    public void setItem(StockItem item) {
        this.item = item;
    }

    public Comment(int id, String body, Date timestamp) {
        this.id = id;
        this.body = body;
        this.timestamp = timestamp;
    }
}
