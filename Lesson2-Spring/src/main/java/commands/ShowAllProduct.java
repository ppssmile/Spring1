package commands;

import org.springframework.stereotype.Component;
import services.CartService;

import java.util.Scanner;

@Component
public class ShowAllProduct implements Command{
    @Override
    public String getName() {
        return "PRODUCTS";
    }

    @Override
    public CartService execute(Scanner scanner, CartService cartService) {
        if (cartService==null){
            System.out.println("Cart is null. Please enter \"new\" for creating new Cart:");
            return cartService;
        }
        System.out.println(cartService.getProductRepository().toString());
        return cartService;
    }
}
