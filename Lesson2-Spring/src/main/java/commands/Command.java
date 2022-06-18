package commands;

import services.CartService;

import java.util.Scanner;

public interface Command {
    String getName();

    CartService execute(Scanner scanner, CartService cartService);
}
