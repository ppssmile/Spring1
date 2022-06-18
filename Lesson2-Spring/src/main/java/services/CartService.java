package services;

import entityes.Product;
import repositoryes.ProductRepository;

import java.util.Map;

public interface CartService {
    void addProduct(Long id, Integer count);
    void deleteProduct(Long id,Integer count);

    Map<Product, Integer> getCart();

    void showCartList();

    ProductRepository getProductRepository();
}
