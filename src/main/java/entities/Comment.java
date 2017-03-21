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

    /*public Comment(User user, StockItem item){
        this.user = user;
        this.item = item;
    }*/
    @Id
    @Column
    private int id;
    private String body;
    private Date timestamp;

    /*@OneToMany(mappedBy = "comments")
    protected User user;

    @OneToMany(mappedBy = "comments")
    protected StockItem item;*/

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

    public Comment(int id, String body, Date timestamp) {
        this.id = id;
        this.body = body;
        this.timestamp = timestamp;
    }
}
