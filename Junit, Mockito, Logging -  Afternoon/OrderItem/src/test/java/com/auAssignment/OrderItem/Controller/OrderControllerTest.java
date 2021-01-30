package com.auAssignment.OrderItem.Controller;

import com.auAssignment.OrderItem.Model.Item;
import com.auAssignment.OrderItem.Model.Order;
import com.auAssignment.OrderItem.Service.OrderServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @InjectMocks
    OrderController orderController;

    @Mock
    OrderServices orderServices;

    @Test
    void createNewOrderTest() {
        Mockito.when(orderServices.createNewOrder(Mockito.any(Order.class))).thenReturn("New order created successfully!");

        Item item1 = new Item(1, "Test item 1", "description");
        Item item2 = new Item(2, "Test item 2", "description");
        Item item3 = new Item(3, "Test item 3", "description");

        List<Item> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);

        Order order = new Order();
        order.setOrderId(1);
        order.setItemList(itemList);

        ResponseEntity<String> response = orderController.createNewOrder(order);

        Assertions.assertEquals("New order created successfully!", response.getBody());

        Mockito.when(orderServices.createNewOrder(Mockito.any(Order.class))).thenReturn("Order is duplicate");

        ResponseEntity<String> duplicateResponse = orderController.createNewOrder(order);

        Assertions.assertEquals("Order is duplicate", duplicateResponse.getBody());


    }

    @Test
    void addItemToOrderTest() {
        Mockito.when(orderServices.addItemToOrder(Mockito.any(Item.class), Mockito.anyInt())).thenReturn("Item added successfully to order!");
        Item item1 = new Item(1, "Test item 1", "description");
        ResponseEntity<Object> successResponse = orderController.addItemToOrder(item1, 1);
        Assertions.assertEquals("Item added successfully to order!", successResponse.getBody());

        Mockito.when(orderServices.addItemToOrder(Mockito.any(Item.class), Mockito.anyInt())).thenReturn("Item is duplicate");
        ResponseEntity<Object> itemDuplicateResponse = orderController.addItemToOrder(item1, 1);
        Assertions.assertEquals("Item is duplicate", itemDuplicateResponse.getBody());


        Mockito.when(orderServices.addItemToOrder(Mockito.any(Item.class), Mockito.anyInt())).thenReturn("Order not found!");
        ResponseEntity<Object> orderNotFoundResponse = orderController.addItemToOrder(item1, 1);
        Assertions.assertEquals("Order not found!", orderNotFoundResponse.getBody());

    }

    @Test
    void getOrderByIdTest() {

        Order order = new Order();

        Mockito.when(orderServices.getOrderById(Mockito.anyInt())).thenReturn(order);

        ResponseEntity<Object> successResponse = orderController.getOrderById(1);

        Assertions.assertEquals(order, successResponse.getBody());

        Mockito.when(orderServices.getOrderById(Mockito.anyInt())).thenReturn(null);

        ResponseEntity<Object> nullResponse = orderController.getOrderById(1);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, nullResponse.getStatusCode());

    }

    @Test
    void deleteItemTest() {

        Mockito.when(orderServices.deleteItemFromOrder(Mockito.anyInt(), Mockito.anyInt())).thenReturn("Item removed successfully!");
        ResponseEntity<Object> successResponse = orderController.deleteItem(1, 1);
        Assertions.assertEquals("Item removed successfully!", successResponse.getBody());

        Mockito.when(orderServices.deleteItemFromOrder(Mockito.anyInt(), Mockito.anyInt())).thenReturn("Item not found!");
        ResponseEntity<Object> itemNotFoundResponse = orderController.deleteItem(1, 1);
        Assertions.assertEquals("Item not found!", itemNotFoundResponse.getBody());

        Mockito.when(orderServices.deleteItemFromOrder(Mockito.anyInt(), Mockito.anyInt())).thenReturn("Order not found!");
        ResponseEntity<Object> orderNotFoundResponse = orderController.deleteItem(1, 1);
        Assertions.assertEquals("Order not found!", orderNotFoundResponse.getBody());

    }

    @Test
    void updateItemQuantityTest() {

        Mockito.when(orderServices.updateItemQuantity(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn("Item quantity updated successfully!");
        ResponseEntity<Object> successResponse = orderController.updateItemQuantity(1, 1, 10);
        Assertions.assertEquals("Item quantity updated successfully!", successResponse.getBody());

        Mockito.when(orderServices.updateItemQuantity(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn("Item not found!");
        ResponseEntity<Object> itemNotFoundResponse = orderController.updateItemQuantity(1, 1, 10);
        Assertions.assertEquals("Item not found!", itemNotFoundResponse.getBody());

        Mockito.when(orderServices.updateItemQuantity(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn("Order not found!");
        ResponseEntity<Object> orderNotFoundResponse = orderController.updateItemQuantity(1, 1, 10);
        Assertions.assertEquals("Order not found!", orderNotFoundResponse.getBody());

    }
}