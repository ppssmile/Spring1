package HomeWork1;

import java.util.Random;

public class Product {
    private Long id;
    private String title;
    private Long cost;


    public Product(String title) {
        this.cost= (long) (100 + new Random().nextInt(0, 150));
        this.title = "Product"+title;
    }

    public Product(String title, Long cost) {
        this.title = title;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Product setTitle(String title) {
        this.title = title;
        return this;
    }

    public Long getCost() {
        return cost;
    }

    public Product setCost(Long cost) {
        this.cost = cost;
        return this;
    }

}
