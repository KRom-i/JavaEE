package DemoProduct.Services;

import DemoProduct.Product.Product;
import DemoProduct.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

    public Iterator<Product> getPage(Integer page, Integer size){
        this.page = page; this.size = size;
        return repository.findAll(PageRequest.of(page, size)).iterator();
    }

    public Iterator<Product> getSortDesc(String property){
        return getSort(Sort.Direction.DESC, property);
    }

    public Iterator<Product> getSortAsc (String property) {
        return getSort(Sort.Direction.ASC, property);
    }

    private Iterator<Product> getSort(Sort.Direction direction, String property){
        return repository.findAll(PageRequest.of(page, size, Sort.by(direction, property))).iterator();
    }

    public boolean deleteProduct (Long id) {
        try {
            repository.deleteById (id);
        } catch (EmptyResultDataAccessException e){
            return false;
        }
        return true;
    }

    public List<Product> getGreater (Integer price) {
        return repository.findProductsByPriceGreaterThanEqualOrderByPriceAsc (price);
    }

    public List<Product> getLess (Integer price) {
        return repository.findProductsByPriceLessThanEqualOrderByPriceAsc (price);
    }

    public List<Product> getPriceRange(Integer minPrice, Integer maxPrice){
        return repository.findProductsByPriceGreaterThanEqualAndPriceLessThanEqualOrderByPriceAsc (minPrice, maxPrice);
    }
}

