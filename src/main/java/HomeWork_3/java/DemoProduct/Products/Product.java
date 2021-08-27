package HomeWork_3.java.DemoProduct.Products;

import java.util.Random;


public class Product {

    private int id;
    private String title;
    private int cost;

    public Product () {
    }

    public Product (int id, String title) {
        this.id = id;
        this.title = title;
        this.cost = getRandom();
    }


    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public int getCost () {
        return cost;
    }

    public void setCost (int cost) {
        this.cost = cost;
    }

    private int getRandom () {
        return new Random().nextInt(900) + 100;
    }

    @Override
    public String toString () {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                '}';
    }
}
