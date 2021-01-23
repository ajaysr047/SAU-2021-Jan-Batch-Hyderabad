package com.auAssignment.OrderItem.Service.Implementation;

import com.auAssignment.OrderItem.Model.Item;
import com.auAssignment.OrderItem.Model.Order;
import com.auAssignment.OrderItem.Service.OrderServices;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServicesImpl implements OrderServices {

    static List<Order> orderList = new ArrayList<>();

    private boolean isItemDuplicate(int itemId, int orderIndex) {
        for(Item item : orderList.get(orderIndex).getItemList())
            if(item.getItemId() == itemId)
                return true;
        return false;
    }

    private int findOrderIndex(int orderId) {
        for(int i = 0; i < orderList.size(); i++)
            if(orderList.get(i).getOrderId() == orderId)
                return i;
        return -1;
    }

    private boolean isOrderDuplicate(int orderId) {
        for(Order order : orderList)
            if(order.getOrderId() == orderId)
                return true;
            return false;
    }

    private int findItemIndex(int itemId, int orderIndex) {
        for(int i = 0; i < orderList.get(orderIndex).getItemList().size(); i++)
            if(orderList.get(orderIndex).getItemList().get(i).getItemId() == itemId)
                return i;
        return -1;
    }


    @Override
    public String createNewOrder(Order order) {

        if(!isOrderDuplicate(order.getOrderId())){
            orderList.add(order);
            return "New order created successfully!";
        }
        return "Order is duplicate!";
    }

    @Override
    public String addItemToOrder(Item item, int orderId) {
        int orderIndex = findOrderIndex(orderId);
        if(orderIndex != -1){
            if(!isItemDuplicate(item.getItemId(), orderIndex)){
                orderList.get(orderIndex).getItemList().add(item);
                return "Item added successfully to order!";
            }
            else
                return "Item is duplicate!";
        }
        return "Order not found!";
    }

    @Override
    public Order getOrderById(int orderId) {
        int orderIndex = findOrderIndex(orderId);
        if(orderIndex != -1)
            return orderList.get(orderIndex);
        return null;
    }

    @Override
    public String deleteItemFromOrder(int orderId, int itemId) {
        int orderIndex = findOrderIndex(orderId);
        if(orderIndex != -1) {
            int itemIndex = findItemIndex(itemId, orderIndex);
            if(itemIndex != -1){
                orderList.get(orderIndex).getItemList().remove(itemIndex);
                return "Item removed successfully!";
            }
            else
                return "Item not found!";
        }
        return "Order not found!";
    }

    @Override
    public String updateItemQuantity(int orderId, int itemId, int quantity) {
        int orderIndex = findOrderIndex(orderId);
        if(orderIndex != -1) {
            int itemIndex = findItemIndex(itemId, orderIndex);
            if(itemIndex != -1){
                orderList.get(orderIndex).getItemList().get(itemIndex).setItemQuantity(quantity);
                return "Item quantity updated successfully!";
            }
            else
                return "Item not found!";
        }
        return "Order not found!";
    }
}
