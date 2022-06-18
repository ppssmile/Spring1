package repositoryes.impl;

import entityes.Product;
import entityes.impl.ProductImpl;
import org.springframework.stereotype.Repository;
import repositoryes.ProductRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final AtomicLong identity = new AtomicLong(0);

    private final Map<Long, Product> productMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        this.save(new ProductImpl());
        this.save(new ProductImpl());
        this.save(new ProductImpl());
        this.save(new ProductImpl());
        this.save(new ProductImpl());
    }

    @Override
    public Product findByID(long id) {
        return productMap.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        if (product.getId()==null){
            long id = identity.incrementAndGet();
            product.init(id);
        }
        productMap.put(product.getId(), product);
    }

    @Override
    public void delete(Long id) {
        productMap.remove(id);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        productMap.values()
                .forEach(product -> str.append(product.getId() + ". " +
                                                       product.getName() + "  " +
                                                       product.getCost() + "\n"));
        return str.toString();
    }
}
