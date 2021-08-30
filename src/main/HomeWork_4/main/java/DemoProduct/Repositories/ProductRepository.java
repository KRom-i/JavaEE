package DemoProduct.Repositories;



import DemoProduct.Products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    private Products products;

    public List<Product> getProducts () {
        return products.getProducts();
    }

    public void addProduct(Product product){
        products.add(product);
    };
}
