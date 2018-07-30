package ua.Light.shop.services.dto;

public class OrderDto {

    private Long id;
    private Long userId;
    private Long productId;
    private String name;
    private int count;

    public OrderDto() {
    }

    public OrderDto(Long id, Long userId, Long productId, String name, int count) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.name = name;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
