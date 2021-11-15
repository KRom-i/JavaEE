package DemoProduct.Repositories;



import DemoProduct.Products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    /*
    3. * Вшить ProductDao в веб-проект, и показывать товары, лежащие в базе данных.
     */

    @Autowired
    private ProductDao productDao;

    public List<Product> findAll () {
        return productDao.findAll();
    }

    public void save (Product product) {
        productDao.saveOrUpdate(product);
    }

    public Product findById (Long id) {
        return productDao.findById(id);
    }

}