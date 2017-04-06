package entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({
        @NamedQuery(name = "cart.findAll", query = "select i from Cart i"),
        @NamedQuery(name = "cart.findByUser", query = "select i from Cart i where i.user=:user")
})

@Entity
@XmlRootElement
public class Cart {

    public Cart(){

    }

    @GeneratedValue
    @Id
    private int id;
    private Boolean paid;

    @ManyToOne
    private User user;

    @ManyToOne
    private StockItem stockItem;

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    @XmlElement
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @XmlElement
    public StockItem getStockItem() {
        return stockItem;
    }

    public void setStockItem(StockItem stockItem) {
        this.stockItem = stockItem;
    }

}
