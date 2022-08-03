package com.ecomApp.Ecom.cart;

import com.ecomApp.Ecom.products.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cart")
@PrimaryKeyJoinColumn(name = "cartId")
public class Cart extends Product {
    private int quantity;
}
