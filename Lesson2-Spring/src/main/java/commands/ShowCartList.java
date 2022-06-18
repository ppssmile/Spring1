package commands;

import org.springframework.stereotype.Component;
import services.CartService;
import services.impl.CartServiceImpl;

import java.util.Scanner;

@Component
public class ShowCartList implements Command{
    @Override
    public String getName() {
        return "SHOW";
    }

    @Override
    public CartService execute(Scanner scanner, CartService cartService) {
        if (cartService == null) {
            System.out.println("Cart is null. ");
            return cartService;
        }
        cartService.showCartList();
        return cartService;
    }
}
