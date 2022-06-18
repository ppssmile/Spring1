import commands.CommandHandler;
import config.JavaConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repositoryes.ProductRepository;
import repositoryes.impl.ProductRepositoryImpl;
import services.CartService;
import services.impl.CartServiceImpl;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context           = new AnnotationConfigApplicationContext(JavaConfig.class);
        ProductRepository productRepository = context.getBean("productRepository", ProductRepositoryImpl.class);
        CartService    cart           = context.getBean("cartService", CartServiceImpl.class);
        CommandHandler commandHandler = context.getBean(CommandHandler.class);
        commandHandler.handlersCommands();

    }
}

