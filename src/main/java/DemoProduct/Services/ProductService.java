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
        repository.addProduct(product);
    }

    public Product getProductById (Long id) {
        try {
            return repository.findById(id);
        } catch (NoSuchElementException e){
            return null;
        }
    }

    public Product getProduct () {
        return new Product();
    }
}
