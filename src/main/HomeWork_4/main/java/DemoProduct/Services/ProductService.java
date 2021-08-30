package DemoProduct.Services;

import DemoProduct.Products.Product;
import DemoProduct.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getProducts(){
        return repository.getProducts();
    }

    public void addProduct(Product product){

        product.setId(repository.getProducts().size() + 1);

        repository.addProduct(product);
    }

    public Product getProductById (int id) {

        if (id <= 0 || id > repository.getProducts().size()) return null;

        return repository.getProducts().get(id - 1);
    }

    public Product getProduct () {
        return new Product();
    }
}
