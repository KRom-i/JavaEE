package HomeWork_3.java.DemoProduct.Products;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Products {

    private final String[] titles = {"Apple", "Pear", "Orange", "Lemon",
            "Banana", "Watermelon", "Pomegranate", "Mardarin", "Kiwi", "Grapes"};

    private List<Product> products;

    public Products () {
        this.products = new ArrayList<>();
        initArray();
    }

    public void add(Product product){
        products.add(product);
    }

    public List<Product> getProducts () {
        return products;
    }

    private void initArray () {
        for (int i = 0; i < titles.length; i++) {
            products.add(new Product((i + 1), titles[i]));
        }
    }
}
