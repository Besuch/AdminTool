package ua.light.shop.services.dto;

public class ProductDto {
    private String name;
    private String category;
    private String color;
    private String parameter;
    private int count;
    private int price;

    public ProductDto() {
    }

    public ProductDto(String name, String category, String color, String parameter, int count, int price) {
        this.name = name;
        this.category = category;
        this.color = color;
        this.parameter = parameter;
        this.count = count;
        this.price = price;
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

    @Override
    public String toString() {
        return "ProductDto{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", color='" + color + '\'' +
                ", parameter='" + parameter + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}