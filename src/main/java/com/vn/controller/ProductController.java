package com.vn.controller;

import com.vn.request.ProductRequest;
import com.vn.response.ProductResponse;
import com.vn.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/product")
@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProduct(){
        return productService.getAll();
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<ProductResponse> findByIdProduct(
            @PathVariable(value = "id") int id
    ){
        return productService.findByIdProduct(id);
    }

    @GetMapping("/search/name/{nameProduct}")
    public ResponseEntity<List<ProductResponse>> findByNameProduct(
            @PathVariable(value = "nameProduct") String name
    ){
        return productService.findByNameProduct(name);
    }

    @PostMapping("/create")
    public ResponseEntity<ProductResponse> createProduct(
            @RequestBody ProductRequest productRequest
            ){
        return productService.createProduct(productRequest);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductResponse> createProduct(
            @PathVariable(value = "id") int id,
            @RequestBody ProductRequest productRequest
    ){
        return productService.updateProduct(id,productRequest);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String,Integer>> deleteProduct(
        @PathVariable(value = "id") int id
    ){
        System.out.println(id);
        return productService.deleteProduct(id);
    }

}
