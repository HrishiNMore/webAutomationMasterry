package com.hrishi.webautomation.models;

import lombok.Data;
@Data
public class cart {
    private String productName;
    private String size;
    private int quantity;

    public cart(String productName, String sizeInfo) {
        this.productName = productName;
        this.size = sizeInfo;
//        this.quantity = Integer.parseInt(quantity);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "productName='" + productName + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

    public String getSizeInfo() {
        return size;
    }
}
