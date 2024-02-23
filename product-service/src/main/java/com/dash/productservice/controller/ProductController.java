package com.dash.productservice.controller;

import com.dash.productservice.beans.ProductRequest;
import com.dash.productservice.beans.ProductResponse;
import com.dash.productservice.beans.ProductResponseList;
import com.dash.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("/addProduct")
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) {
        long productId = productService.addProduct(productRequest);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('Admin') || hasAuthority('Customer') || hasAuthority('SCOPE_internal')")
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long productId) {
        ProductResponse productResponse = productService.getProductById(productId);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('Admin') || hasAuthority('Customer') || hasAuthority('SCOPE_internal')")
    @GetMapping("/allProducts")
    public ResponseEntity<ProductResponseList> getAllProducts() {
        ProductResponseList productResponses = productService.getAllProducts();
        return new ResponseEntity<>(productResponses, HttpStatus.OK);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable("id") long productId, @RequestBody ProductRequest productRequest) {
        productService.updateProduct(productId, productRequest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/reduceQuantity/{id}")
    public ResponseEntity<Void> reduceQuantity(@PathVariable("id") long productId, @RequestParam int quantity) {
        productService.reduceQuantity(productId, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
