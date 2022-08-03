package com.ecomApp.Ecom.cart;

import com.ecomApp.Ecom.orders.OrderRepository;
import com.ecomApp.Ecom.orders.Orders;
import com.ecomApp.Ecom.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServices {

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> listAllProduct(){
        return cartRepository.findAll();
    }


    public void createProduct(Cart cart) {
        cartRepository.save(cart);
    }


    public Optional<Cart> getProductsById(Long id) {
        return cartRepository.findById(id);
    }

    public void deleteProductInCart(Long id){
        cartRepository.deleteById(id);
    }

    public List<Cart> getProductsByName(String productName){
        return cartRepository.findByNameEqualsAllIgnoreCase(productName);
    }



    public Cart updateOrders(Long id, Cart cart) {
        Cart cart1 = cartRepository.findById(id).get();

        cart1.setName(cart.getName());
        cart1.setCategory(cart.getCategory());
        cart1.setUnitPrice(cart.getUnitPrice());
        cart1.setProductImage(cart.getProductImage());
        cart1.setQuantity(cart.getQuantity());

        cartRepository.save(cart1);

        return cart;
    }
}
