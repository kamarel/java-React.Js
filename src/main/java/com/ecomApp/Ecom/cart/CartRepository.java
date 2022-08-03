package com.ecomApp.Ecom.cart;

import com.ecomApp.Ecom.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByNameEqualsAllIgnoreCase(String name);
}
