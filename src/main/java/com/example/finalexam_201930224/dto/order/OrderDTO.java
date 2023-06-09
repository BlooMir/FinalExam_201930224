package com.example.finalexam_201930224.dto.order;

public class OrderDTO {

    private long productId;
    private String productName;
    private String userId;
    private String userName;
    private int price;

    public OrderDTO(long productId, String productName, String userId, String userName, int price) {
        this.productId = productId;
        this.productName = productName;
        this.userId = userId;
        this.userName = userName;
        this.price = price;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
