package DemoProduct.Products;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    /*
    Задание 1. Создайте сущность Product (Long id, String title, int price)
    и таблицу в базе данных для хранения объектов этой сущности;
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;


    public Product () {
    }


    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public int getPrice () {
        return price;
    }

    public void setPrice (int price) {
        this.price = price;
    }


    @Override
    public String toString () {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
