package entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({
        @NamedQuery(name = "stockItem.findAll", query = "select i from StockItem i"),
        @NamedQuery(name = "stockItem.findById", query = "select i from StockItem i where i.stockItemId=:stockItemId")
})

@Entity
@XmlRootElement
public class StockItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int stockItemId, quantity;
    private String title, manuf, category, image, description;
    private double price;

    public StockItem(int stockItemId, String title, String manuf, String category, String image, double price, int quantity, String description) {
        this.stockItemId = stockItemId;
        this.title = title;
        this.manuf = manuf;
        this.category = category;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }
    @XmlElement
    public int getStockItemId() {
        return stockItemId;
    }

    public void setStockItemId(int stockItemId) {
        this.stockItemId = stockItemId;
    }
    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement
    public String getManuf() {
        return manuf;
    }

    public void setManuf(String manuf) {
        this.manuf = manuf;
    }

    @XmlElement
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @XmlElement
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlElement
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StockItem() {
    }

    /*@ManyToOne(optional = false)
    private Comment comments;

    public Comment getComments() {
        return comments;
    }

    public void setComments(Comment comments) {
        this.comments = comments;
    }*/
}
