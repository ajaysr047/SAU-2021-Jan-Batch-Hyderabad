package com.auAssignment.OrderItem.Service;

import com.auAssignment.OrderItem.Model.Item;
import com.auAssignment.OrderItem.Model.Order;

public interface OrderServices {

    public String createNewOrder(Order order);
    public String addItemToOrder(Item item, int orderId);
    public Order getOrderById(int orderId);
    public String deleteItemFromOrder(int orderId, int itemId);
    public String updateItemQuantity(int orderId, int itemId, int quantity);
}
