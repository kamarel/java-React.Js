package com.ecomApp.Ecom.orders;

import com.ecomApp.Ecom.products.Product;
import com.ecomApp.Ecom.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServices {

    @Autowired
    private OrderRepository orderRepository;

    public List<Orders> listAllProduct(){
        return orderRepository.findAll();
    }


    public void createProduct(Orders orders) {
        orderRepository.save(orders);
    }


    public Optional<Orders> getProductsById(Long id) {
        return orderRepository.findById(id);
    }

    public void deleteProduct(Long id){
        orderRepository.deleteById(id);
    }

    public List<Orders> getProductsByName(String productName){
        return orderRepository.findByNameEqualsAllIgnoreCase(productName);
    }



    public Orders updateOrders(Long id, Orders orders) {
        Orders orders1 = orderRepository.findById(id).get();

        orders1.setName(orders.getName());
        orders1.setCategory(orders.getCategory());
        orders1.setUnitPrice(orders.getUnitPrice());
        orders1.setProductImage(orders.getProductImage());
        orders1.setOrderPrice(orders.getOrderPrice());
        orders1.setOrderDate(orders.getOrderDate());
        orders1.setQuantity(orders.getQuantity());
        orders1.setUserId(orders.getUserId());
        orders1.setOrderDate(orders.getOrderDate());
        orderRepository.save(orders1);
        return orders;
    }
}
