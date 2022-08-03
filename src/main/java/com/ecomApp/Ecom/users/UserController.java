package com.ecomApp.Ecom.users;

import com.ecomApp.Ecom.Exception.ResourceNotFoundException;
import com.ecomApp.Ecom.cart.Cart;
import com.ecomApp.Ecom.orders.OrderServices;
import com.ecomApp.Ecom.orders.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class UserController {


    @Autowired
    private UserServices userServices;

    @GetMapping("/users")
    public List<User> listAll(){
        return userServices.listAllUser();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        try {
            Optional<User> user = userServices.getUserById(id);
            System.out.println(user);
            return user;
        }catch (NoSuchElementException e ) {
            return null;
        }
    }



    @PostMapping("/users")
    public void addProduct(@RequestBody User user){
        userServices.createNewUser(user);
    }


    @DeleteMapping("/users/{id}")
    public void deleteProduct(@PathVariable Long id) {
        userServices.deleteUser(id);
    }


    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateOrder(@PathVariable Long id, @RequestBody User user) {
        user = userServices.updateUser(id, user);

        return ResponseEntity.ok(user);
    }
}
