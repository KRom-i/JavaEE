package com.gb.springthymeleafproduct.Services;

import com.gb.springthymeleafproduct.Product.Product;
import com.gb.springthymeleafproduct.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;


@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Page<Product> getProducts(Pageable pageable){
        return repository.findAll (pageable);
    }

    public void saveProduct(Product product){
        repository.save(product);
    }

    public Product getProduct () {
        return new Product();
    }

    public void deleteProduct (Long id) {
        repository.deleteById (id);
    }

}

