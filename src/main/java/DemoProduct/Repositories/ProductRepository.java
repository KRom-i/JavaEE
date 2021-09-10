package DemoProduct.Repositories;

import DemoProduct.Product.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    List<Product> findProductsByPriceGreaterThanEqualOrderByPriceAsc (Integer price);

    List<Product> findProductsByPriceLessThanEqualOrderByPriceAsc (Integer price);

    List<Product> findProductsByPriceGreaterThanEqualAndPriceLessThanEqualOrderByPriceAsc (Integer minPrice, Integer maxPrice);

}
