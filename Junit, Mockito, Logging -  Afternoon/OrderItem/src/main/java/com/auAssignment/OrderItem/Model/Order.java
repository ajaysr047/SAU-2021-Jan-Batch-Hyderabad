package com.auAssignment.OrderItem.Model;

import java.util.List;

public class Order {
    private int orderId;
    private List<Item> itemList;

    public Order(){}

    public Order(int orderId, List<Item> itemList) {
        this.orderId = orderId;
        this.itemList = itemList;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
