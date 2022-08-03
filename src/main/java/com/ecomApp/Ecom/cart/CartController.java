package com.ecomApp.Ecom.cart;


import com.ecomApp.Ecom.orders.OrderServices;
import com.ecomApp.Ecom.orders.Orders;
import com.ecomApp.Ecom.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class CartController {
    @Autowired
    private CartServices cartServices;



    @GetMapping("/cart")
    public List<Cart> listAll(){
        return cartServices.listAllProduct();
    }

    @GetMapping("/cart/{id}")
    public Optional<Cart> getProductById(@PathVariable Long id){
        try {
            Optional<Cart> product = cartServices.getProductsById(id);
            System.out.println(product);
            return product;
        }catch (NoSuchElementException e ) {
            return null;
        }
    }

    @GetMapping("cart/{name}")
    public ResponseEntity<Cart> getProductByName(@PathVariable String name){
        Cart cart = (Cart) cartServices.getProductsByName(name);
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/cart")
    public void addProduct(@RequestBody Cart cart){
        cartServices.createProduct(cart);
    }


    @DeleteMapping("/cart/{id}")
    public void deleteProduct(@PathVariable Long id) {
        cartServices.deleteProductInCart(id);
    }


    @PutMapping("/cart/{id}")
    public ResponseEntity<Cart> updateOrder(@PathVariable Long id, @RequestBody Cart cart) {
        cart = cartServices.updateOrders(id, cart);

        return ResponseEntity.ok(cart);
    }


}
