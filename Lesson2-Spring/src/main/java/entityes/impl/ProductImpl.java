package entityes.impl;

import entityes.Product;
import lombok.ToString;
import java.util.Objects;

@ToString
public class ProductImpl implements Product {

    private Long id;
    private String name;
    private Long cost;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Long getCost() {
        return cost;
    }


    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setCost(Long cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductImpl product = (ProductImpl) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public Product init(Long id) {
        setId(id);
        setName("product_"+id);
        setCost(100*id);
        return this;
    }
}