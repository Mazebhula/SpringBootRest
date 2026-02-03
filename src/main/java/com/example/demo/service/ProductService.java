package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductDai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductDai repo;
    public List<Product> getAllProducts(){
        return repo.findAll() ;
    }
    public Product getProductByID(int Id){
        return repo.getReferenceById(Id);
    }
    public void addProduct(Product product){
        repo.save(product);
    }
    public void deleteProduct(Product product){
        repo.delete(product);
    }
}
