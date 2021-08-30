package DemoProduct;

import DemoProduct_2.Products.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Sessions {

    private SessionFactory factory;

    public SessionFactory getFactory () {

        if (factory != null) return factory;

        factory =  new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        return factory;
    }
}
