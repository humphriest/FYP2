package entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({
        @NamedQuery(name = "cart.findAll", query = "select i from Cart i"),
        @NamedQuery(name = "cart.findByUser", query = "select i from Cart i where i.user=:user"),
        @NamedQuery(name = "cart.findById", query = "select i from Cart i where i.id=:id")
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
    private int quantity;
    private double totalPrice;

    @ManyToOne
    private User user;

    @ManyToOne
    private StockItem stockItem;

    @XmlElement
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @XmlElement
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }


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
