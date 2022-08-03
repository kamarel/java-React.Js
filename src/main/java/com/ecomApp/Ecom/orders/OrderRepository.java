package com.ecomApp.Ecom.orders;

import com.ecomApp.Ecom.products.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Orders, Long>, JpaSpecificationExecutor<Orders> {
    List<Orders> findByNameEqualsAllIgnoreCase(String name);

}
