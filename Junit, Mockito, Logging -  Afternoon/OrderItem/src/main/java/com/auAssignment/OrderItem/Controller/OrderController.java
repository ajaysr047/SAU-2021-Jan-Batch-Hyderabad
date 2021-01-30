package com.auAssignment.OrderItem.Controller;

import com.auAssignment.OrderItem.Model.Item;
import com.auAssignment.OrderItem.Model.Order;
import com.auAssignment.OrderItem.Service.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderServices orderServices;

    @PostMapping("/create")
    public ResponseEntity<String> createNewOrder(@RequestBody Order order) {
        String response = orderServices.createNewOrder(order);
        if(response.contains("successfully"))
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        return  new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @PostMapping("/addItem/{orderId}")
    public ResponseEntity<Object> addItemToOrder(@RequestBody Item item, @PathVariable("orderId") int orderId){

        String response = orderServices.addItemToOrder(item, orderId);
        if(response.contains("successfully"))
            return ResponseEntity.ok(response);
        else if(response.contains("duplicate"))
            return  new ResponseEntity<>(response, HttpStatus.CONFLICT);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getOrder/{orderId}")
    public ResponseEntity<Object> getOrderById(@PathVariable("orderId") int orderId){

        Order getOrder = orderServices.getOrderById(orderId);
        if(getOrder != null)
            return ResponseEntity.ok(getOrder);
        return new ResponseEntity<>("Order not found!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteItem/{orderId}/{itemId}")
    public ResponseEntity<Object> deleteItem(@PathVariable("orderId") int orderId, @PathVariable("itemId") int itemId){
        String response = orderServices.deleteItemFromOrder(orderId, itemId);
        if(response.contains("successfully"))
            return ResponseEntity.ok(response);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/updateItemQuantity/{orderId}/{itemId}/{itemQuantity}")
    public ResponseEntity<Object> updateItemQuantity(@PathVariable("orderId") int orderId, @PathVariable("itemId") int itemId, @PathVariable("itemQuantity") int itemQuantity){
        String response = orderServices.updateItemQuantity(orderId, itemId, itemQuantity);
        if(response.contains("successfully"))
            return ResponseEntity.ok(response);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
