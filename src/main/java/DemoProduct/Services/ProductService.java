package DemoProduct.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.NoSuchElementException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    private Integer page;
    private Integer size;

    public Iterable<Product> getProducts(){
        return repository.findAll();
    }

    public void addProduct(Product product){
       repository.save(product);
    }

    public Product getProductById (Long id) {
        try {
            return repository.findById(id).get();
        } catch (NoSuchElementException e){
            return null;
        }
    }

    public Product getProduct () {
        return new Product();
    }



}

