package com.vn.service;

import com.vn.request.ProductRequest;
import com.vn.response.ProductResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ProductService {
    public ResponseEntity<List<ProductResponse>> getAll();
    public ResponseEntity<List<ProductResponse>> findByNameProduct(String name);
    public ResponseEntity<ProductResponse> findByIdProduct(Integer productId);
    public ResponseEntity<ProductResponse> createProduct(ProductRequest productRequest);
    public ResponseEntity<ProductResponse> updateProduct(int idProduct,ProductRequest productRequest);
    public ResponseEntity<Map<String,Integer>> deleteProduct(Integer productId);

}
