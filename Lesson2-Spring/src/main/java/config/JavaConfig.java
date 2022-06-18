package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import repositoryes.ProductRepository;
import repositoryes.impl.ProductRepositoryImpl;
import services.CartService;
import services.impl.CartServiceImpl;


@Configuration
@ComponentScan( "commands")
public class JavaConfig {

    @Bean
    public ProductRepository productRepository(){
        return new ProductRepositoryImpl();
    }

    @Bean
    @Scope("prototype")
    public CartService cartService(){
        return new CartServiceImpl();
    }
}
