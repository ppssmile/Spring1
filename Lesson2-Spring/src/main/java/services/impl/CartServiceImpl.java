package services.impl;

import entityes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import repositoryes.ProductRepository;
import repositoryes.impl.ProductRepositoryImpl;
import services.CartService;

import java.util.HashMap;
import java.util.Map;

public class CartServiceImpl implements CartService {

    @Autowired
    private ProductRepository prodRepo;

    private final Map<Product, Integer> cart;

    public CartServiceImpl() {
        this.cart = new HashMap<>();
        this.prodRepo = new ProductRepositoryImpl();
    }

    @Override
    public void addProduct(Long id, Integer count) {
        var product = prodRepo.findByID(id);
        if (product != null) {
            cart.merge(product, count, Integer::sum);
        }
    }

    @Override
    public void deleteProduct(Long id, Integer count) {
        var product = prodRepo.findByID(id);
        if (count > cart.get(product)) {
            cart.remove(product);
        } else {
            cart.merge(product, -count, Integer::sum);
        }
    }

    @Override
    public Map<Product, Integer> getCart() {
        return this.cart;
    }

    @Override
    public ProductRepository getProductRepository() {
        return prodRepo;
    }

    @Override
    public void showCartList() {
        this.cart.entrySet().forEach(entry -> System.out.println(entry.getKey().toString() + " - count: " + entry.getValue() + ",  Summary cost: " + entry.getValue() * entry.getKey().getCost()));
    }
}
