package entityes;


public interface Product {


    Long getId();
    String getName();
    Long getCost();

    void setId(Long id);
    void setName(String name);
    void setCost(Long cost);

    Product init(Long id);
}
