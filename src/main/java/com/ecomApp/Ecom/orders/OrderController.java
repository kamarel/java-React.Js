package com.ecomApp.Ecom.orders;


import com.ecomApp.Ecom.Exception.ResourceNotFoundException;
import com.ecomApp.Ecom.products.Product;
import com.ecomApp.Ecom.products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderServices orderServices;

    @GetMapping("/orders")
    public List<Orders> listAll(){
        return orderServices.listAllProduct();
    }

    @GetMapping("/orders/{id}")
    public Optional<Orders> getProductById(@PathVariable Long id){
        try {
            Optional<Orders> product = orderServices.getProductsById(id);
            System.out.println(product);
            return product;
        }catch (NoSuchElementException e ) {
            return null;
        }
    }

    @GetMapping("orders/{name}")
    public ResponseEntity<Orders> getProductByName(@PathVariable String name){
        Orders orders = (Orders) orderServices.getProductsByName(name);
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/orders")
    public void addProduct(@RequestBody Orders orders){
        orderServices.createProduct(orders);
    }


    @DeleteMapping("/orders/{id}")
    public void deleteProduct(@PathVariable Long id) {
        orderServices.deleteProduct(id);
    }


    @PutMapping("/orders/{id}")
    public ResponseEntity<Orders> updateOrder(@PathVariable Long id, @RequestBody Orders orders) {
        orders = orderServices.updateOrders(id, orders);

        return ResponseEntity.ok(orders);
    }


}
