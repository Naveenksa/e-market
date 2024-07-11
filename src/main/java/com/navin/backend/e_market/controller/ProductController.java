package com.navin.backend.e_market.controller;

import com.navin.backend.e_market.entity.Product;
import com.navin.backend.e_market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product)
    {
        productService.addProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(),HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("product deleted",HttpStatus.OK);
    }

    @PatchMapping("/update-spec/{id}")
    public ResponseEntity<Product> updateSpec(@PathVariable long id,@PathVariable Product product){
        return new ResponseEntity<>(productService.updateRate(id,product),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable long id){
        return new ResponseEntity<>(productService.getById(id),HttpStatus.FOUND);
    }

}
