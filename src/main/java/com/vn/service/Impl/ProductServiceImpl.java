package com.vn.service.Impl;

import com.vn.entity.Product;
import com.vn.repository.ProductRepository;
import com.vn.request.ProductRequest;
import com.vn.response.ProductResponse;
import com.vn.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ResponseEntity<List<ProductResponse>> getAll() {
        List<ProductResponse> responseList = productRepository.findAll()
            .stream()
            .map(product -> ProductResponse
                    .builder()
                    .id(product.getId())
                    .nameProduct(product.getNameProduct())
                    .price(product.getPrice())
                    .description(product.getDescription())
                    .build())
            .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }

    @Override
    public ResponseEntity<List<ProductResponse>> findByNameProduct(String name) {
        List<ProductResponse> responseList = productRepository.findByNameProduct(name)
                .map(products -> products
                    .stream()
                    .map(product -> ProductResponse
                        .builder()
                        .id(product.getId())
                        .nameProduct(product.getNameProduct())
                        .price(product.getPrice())
                        .description(product.getDescription())
                        .build())
                    .collect(Collectors.toList()))
                .orElse(null);
        return ResponseEntity.status(HttpStatus.FOUND).body(responseList);
    }

    @Override
    public ResponseEntity<ProductResponse> findByIdProduct(Integer productId) {
        ProductResponse response = productRepository.findByIdProduct(productId)
                .map(product -> ProductResponse
                        .builder()
                        .id(product.getId())
                        .nameProduct(product.getNameProduct())
                        .price(product.getPrice())
                        .description(product.getDescription())
                        .build())
                .orElse(null);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @Override
    public ResponseEntity<ProductResponse> createProduct(ProductRequest productRequest) {
        if (productRequest == null) return null;
        Product product = Product
                .builder()
                .id(productRequest.getId())
                .nameProduct(productRequest.getNameProduct())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
                .build();
        // Save to db
        productRepository.save(product);

        ProductResponse productResponse = ProductResponse
                .builder()
                .id(productRequest.getId())
                .nameProduct(productRequest.getNameProduct())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }

    @Override
    public ResponseEntity<ProductResponse> updateProduct(
            int idProduct,
            ProductRequest productRequest
    ) {
        Product productExist = productRepository.findByIdProduct(idProduct).orElse(null);
        // if product exist we have set value and update product
        productExist.setNameProduct(productRequest.getNameProduct());
        productExist.setDescription(productRequest.getDescription());
        productExist.setPrice(productRequest.getPrice());
        // update to db
        productRepository.save(productExist);

        ProductResponse productResponse = ProductResponse
                .builder()
                .id(productRequest.getId())
                .nameProduct(productRequest.getNameProduct())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

    @Override
    public ResponseEntity<Map<String,Integer>> deleteProduct(Integer productId) {
        Product productExist = productRepository.findByIdProduct(productId).orElse(null);
        Map<String,Integer> response = new HashMap<>();
        if (productExist == null) {
            response.put("Delete failed! Find not found id.",productId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        response.put("Deleted Product by id!",productId);
        productRepository.delete(productExist);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
