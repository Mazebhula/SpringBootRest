package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return service.getAllProducts();
    }
    @GetMapping("/product/{Id}")
    public Product getProduct(@PathVariable int Id){ return service.getProductByID(Id);}
    @PostMapping("/product")
    public void getProducts(@RequestBody Product product){
        service.addProduct(product);
    }
    @PutMapping("/product")
    public void putProducts(@RequestBody Product product){
        service.addProduct(product);
    }
    @DeleteMapping("/product")
    public void deleteProducts(@RequestBody Product product){
        service.deleteProduct(product);
    }
}
