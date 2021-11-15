package DemoProduct.Products;

import DemoProduct_2.Sessions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDao {

    /*
    Задание 2. Создайте класс ProductDao и реализуйте
    в нем логику выполнения CRUD-операций над сущностью Product
    (Product findById(Long id),
    List<Product> findAll(),
    void deleteById(Long id),
    Product saveOrUpdate(Product product));
     */

    @Autowired
    private Sessions sessions;
    private Session session;

    public ProductDao () {
    }

    public void saveOrUpdate(Product product){
        if (product.getId() == null){
            save(product);
        } else {
            update(product);
        }
    }

    private void save(Product product){
        session = sessions.getFactory().getCurrentSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
    }

    private void update(Product product){
        session = sessions.getFactory().getCurrentSession();
        session.beginTransaction();
        Product productUpdate = session.get(Product.class, product.getId());
        productUpdate.setTitle(product.getTitle());
        productUpdate.setPrice(product.getPrice());
        session.getTransaction().commit();
    }

    public Product findById(Long id){

        Product product = null;

        session = sessions.getFactory().getCurrentSession();
        session.beginTransaction();
        product = session.get(Product.class, id);
        session.getTransaction().commit();

        return product;
    }

    public List<Product> findAll(){
        List<Product> productList = null;

        session = sessions.getFactory().getCurrentSession();
        session.beginTransaction();
        productList = session.createQuery("from Product", Product.class).getResultList();
        session.getTransaction().commit();

        return productList;
    }

    public void deleteById(Long id){
        Product product = findById(id);
        delete(product);
    }

    public void delete(Product product){
        session = sessions.getFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(product);
        session.getTransaction().commit();
    }

    public void close(){

        sessions.getFactory().close();

        if (session == null) return;

        session.close();
    };
}
