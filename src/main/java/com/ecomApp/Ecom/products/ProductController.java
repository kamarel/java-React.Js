package com.ecomApp.Ecom.products;

import com.ecomApp.Ecom.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    //private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> listAll(){
        return productService.listAllProduct();
    }

    @GetMapping("{id}")
    public Optional<Product> getProductById(@PathVariable Long id){
        try {
            Optional<Product> product = productService.getProductsById(id);
            System.out.println(product);
            return product;
        }catch (NoSuchElementException e ) {
            return null;
        }
    }

    @GetMapping("/name")
    public ResponseEntity<Product> getProductByName(@PathVariable String name){
        Product product = (Product) productService.getProductsByName(name);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public void addProduct(@RequestBody Product product){
        productService.createProduct(product);
    }


    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }


    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product = productService.updateProduct(id, product);

        return ResponseEntity.ok(product);
    }


  /*  @GetMapping("/name")
    public ResponseEntity<Product> getProductByName(PathVariable String name){
        Product product = (Product) productService.getProducsByName(productName);
    return ResponseEntity.ok(product);
}*/






    /*@PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product productDetails){
        Product updateProduct =  productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product Not found: " +  id));

        updateProduct.setProductName(productDetails.getProductName());
        updateProduct.setCategory(productDetails.getCategory());
        updateProduct.setUnitPrice(productDetails.getUnitPrice());
        updateProduct.setProductImage(productDetails.getProductImage());

        productRepository.save(updateProduct);
        return ResponseEntity.ok(updateProduct);

    }*/
}
