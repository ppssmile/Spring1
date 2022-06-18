package commands;

import org.springframework.stereotype.Component;
import services.CartService;
import services.impl.CartServiceImpl;

import java.util.Scanner;

@Component
public class CartDeleteProduct implements Command{
    @Override
    public String getName() {
        return "DELETE";
    }

    @Override
    public CartService execute(Scanner scanner, CartService cartService) {
        if (cartService == null) {
            System.out.println("Cart is null. ");
            return cartService;
        }
        System.out.println("Enter id:");
        Long id = scanner.nextLong();
        System.out.println("Enter the number of products to remove from the list:");
        Integer count = scanner.nextInt();
        cartService.deleteProduct(id, count);
        return cartService;
    }
}
