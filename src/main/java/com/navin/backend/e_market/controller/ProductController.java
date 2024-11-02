package com.navin.backend.e_market.controller;

import com.navin.backend.e_market.Repository.CustomerRepo;
import com.navin.backend.e_market.entity.Product;
import com.navin.backend.e_market.entity.ProductPatch;
import com.navin.backend.e_market.service.CustomerServiceImpl;
import com.navin.backend.e_market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerRepo customerRepo;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> getAll(@RequestHeader("Authorization") String token, @RequestHeader("email") String email) {


        String secretKey = customerRepo.findByEmail(email).map(c -> c.getSecretKey()).get();
        if (!token.equals(secretKey)) {

            return new ResponseEntity<>("Please Login", HttpStatus.UNAUTHORIZED);

        }
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@RequestHeader("secretKey") String secretKey, @PathVariable long id) {

        if (secretKey.equals(customerRepo.findBySecretKey(secretKey).map(c -> c.getSecretKey()).get())) {
            productService.deleteProduct(id);
            return new ResponseEntity<>("product deleted", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Please Login", HttpStatus.CONTINUE);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return new ResponseEntity<>(productService.updateProduct(id, product), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable long id) {
        return new ResponseEntity<>(productService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/product-sort-by-name")
    public ResponseEntity<Object> getProductSortedByName() {
        List<Product> products = productService.getSortedProductByName();

        if (products.isEmpty()) {
            return new ResponseEntity<>("No Product's Available", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Product> patchProduct(@PathVariable Long id,
                                                @RequestBody ProductPatch productPatch) {

        return ResponseEntity.ok(productService.patchProduct(id, productPatch));
    }
}
