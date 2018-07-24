package ua.Light.shop.dao.model;

public class Product {

    private String name;
    private String category;
    private String color;
    private String parameter;
    private int count;
    private int price;
    private Long id;


    public Product() {
    }

    public Product(String name, String category, String color, String parameter, int count, int price, Long id) {
        this.name = name;
        this.category = category;
        this.color = color;
        this.parameter = parameter;
        this.count = count;
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getColor() {
        return color;
    }

    public String getParameter() {
        return parameter;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", color='" + color + '\'' +
                ", parameter='" + parameter + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}
