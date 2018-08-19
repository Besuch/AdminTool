package ua.light.shop.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CATEGORY", nullable = false)
    private String category;

    @Column(name = "COLOR", nullable = false)
    private String color;

    @Column(name = "PARAMETER", nullable = false)
    private String parameter;

    @Column(name = "COUNT")
    private int count;

    @Column(name = "PRICE")
    private double price;


    public Product() {
    }

    public Product(String name, String category, String color, String parameter, int count, double price, Long id) {
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

    public double getPrice() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return count == product.count &&
                price == product.price &&
                Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(category, product.category) &&
                Objects.equals(color, product.color) &&
                Objects.equals(parameter, product.parameter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, color, parameter, count, price);
    }
}