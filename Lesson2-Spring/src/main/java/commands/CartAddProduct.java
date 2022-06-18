package commands;

import org.springframework.stereotype.Component;
import services.CartService;
import java.util.Scanner;

@Component
public class CartAddProduct implements Command {
    @Override
    public String getName() {
        return "ADD";
    }

    @Override
    public CartService execute(Scanner scanner, CartService cartService) {
        if (cartService == null || cartService.getCart().isEmpty()) {
            System.out.println("Cart is null.");
            return cartService;
        }
        System.out.println("Enter id-product:");
        Long id = scanner.nextLong();
        System.out.println("Enter count product:");
        Integer count = scanner.nextInt();
        cartService.addProduct(id, count);
        return cartService;
    }
}
