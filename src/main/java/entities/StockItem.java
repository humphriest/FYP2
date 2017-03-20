package entities;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "stockItem.findAll", query = "select i from StockItem i"),
        @NamedQuery(name = "stockItem.findById", query = "select i from StockItem i where i.stockItemId=:stockItemId")
})

@Entity
public class StockItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int stockItemId;
    private String title, manuf, category, image;
    private double price;

    public StockItem(String title, String manuf, String category, String image, double price) {
        this.title = title;
        this.manuf = manuf;
        this.category = category;
        this.image = image;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getManuf() {
        return manuf;
    }

    public void setManuf(String manuf) {
        this.manuf = manuf;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public StockItem() {
    }

    @ManyToOne(optional = false)
    private Comment comments;

    public Comment getComments() {
        return comments;
    }

    public void setComments(Comment comments) {
        this.comments = comments;
    }
}
