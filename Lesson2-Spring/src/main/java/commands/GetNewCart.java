package commands;

import config.JavaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import services.CartService;
import java.util.Scanner;

@Component
public class GetNewCart implements Command {

    @Autowired
    private JavaConfig appConfig;

    @Override
    public String getName() {
        return "NEW";
    }

    @Override
    public CartService execute(Scanner scanner, CartService cartService) {
        cartService = appConfig.cartService();
        System.out.println("New cart created" + cartService);
        return cartService;
    }
}
