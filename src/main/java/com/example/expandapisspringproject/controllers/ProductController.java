package com.example.expandapisspringproject.controllers;

import com.example.expandapisspringproject.dao.pojo.Product;
import com.example.expandapisspringproject.dao.pojo.User;
import com.example.expandapisspringproject.dto.ProductPostDto;
import com.example.expandapisspringproject.service.ProductService;
import com.example.expandapisspringproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody ProductPostDto productPostDto) {
        Product product = new Product();
        product.setTable(productPostDto.getTable());
        product.setList(productPostDto.getList());
        productService.addProduct(product);
        return ResponseEntity.ok("User added successfully");
    }
}
