package commands;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import services.CartService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
@Getter
public class CommandHandler {

    private final Map<String, Command> commands;

    @Autowired
    public CommandHandler(List<Command> commands) {
        this.commands = commands.stream()
                .collect(Collectors.toMap(Command::getName, cmd -> cmd));
    }

    public void handlersCommands() {
        Scanner     scanner     = new Scanner(System.in);
        CartService cartService = null;
        String      cmd;
        while (true) {
            System.out.println("Enter command:");
            cmd = scanner.nextLine().trim().toUpperCase();
            if (cmd.equals("EXIT")) {
                System.out.println("Bye!");
                return;
            }
            if (cmd.equals("HELP")) {
                System.out.println(toString());
                continue;
            }
            Command command = commands.get(cmd);
            if (command == null) {
                System.out.println("Command unknown");
                continue;
            }
            cartService = command.execute(scanner, cartService);
        }

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        commands.keySet().forEach(a -> str.append(a + "\n"));
        return "CommandHandler{" +
                "commands:\n" + str;
    }
}
