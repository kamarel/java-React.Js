package com.ecomApp.Ecom.products;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService  {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAllProduct(){
        return productRepository.findAll();
    }


    public void createProduct(Product product) {
        productRepository.save(product);
    }


    public Optional<Product> getProductsById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public List<Product> getProductsByName(String productName){
        return productRepository.findByNameEqualsAllIgnoreCase(productName);
    }



    public Product updateProduct(Long id, Product product) {
        Product product1 = productRepository.findById(id).get();

        product1.setName(product.getName());
        product1.setCategory(product.getCategory());
        product1.setUnitPrice(product.getUnitPrice());
        product1.setProductImage(product.getProductImage());

        productRepository.save(product1);
        return product;
    }



}
