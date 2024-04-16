package com.example.Hokers.controller;

import com.example.Hokers.entity.Product;
import com.example.Hokers.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping
    public List<Product>getAll(){
        return productService.getProducts();
    }

    @GetMapping("/{productId}")
    public Optional<Product> getById(@PathVariable("productId") Long productId){
        return productService.getProduct(productId);
    }
    @PostMapping
    public void saveUpdate(@RequestBody Product product){
        productService.saveOrUpdate(product);
    }

    @DeleteMapping("/{productId}")
    public void deleteById(@PathVariable("productId") Long productId) {productService.delete(productId);
    }

    @PutMapping("/{productId}")
    public void updateProduct(@PathVariable("productId") Long productId, @RequestBody Product product) {
        product.setProductId(productId);
        productService.saveOrUpdate(product);
    }
}
