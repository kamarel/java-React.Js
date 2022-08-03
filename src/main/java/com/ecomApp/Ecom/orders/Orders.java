package com.ecomApp.Ecom.orders;

import com.ecomApp.Ecom.products.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "orderId")
//@PrimaryKeyJoinColumn(referencedColumnName="productId")
public class Orders extends Product {
    @Column(name = "user_id")
    private int userId;
    private double orderPrice;
    private int quantity;
    @Column(name = "Order_Date")
    //@Temporal(TemporalType.DATE)
    private String orderDate ;

}
