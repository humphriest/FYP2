package entities;

import javax.persistence.*;


@Entity
public class StockItem {

    @Id
    @Column
    private int id;
    private String title, manuf, category, image;
    private double price;

    public StockItem(int id, String title, String manuf, String category, String image, double price) {
        this.id = id;
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
}
