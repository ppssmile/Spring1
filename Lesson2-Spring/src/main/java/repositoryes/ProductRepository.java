package repositoryes;

import entityes.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {

    Product findByID(long id);

    List<Product> findAll();

    void save(Product product);

    void delete(Long id);
}
