package com.dash.productservice.service;

import com.dash.productservice.beans.ProductRequest;
import com.dash.productservice.beans.ProductResponse;
import com.dash.productservice.entity.Product;
import com.dash.productservice.exception.ProductServiceCustomException;
import com.dash.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public long addProduct(ProductRequest productRequest) {
        log.info("Adding Product..");

        Product product
                = Product.builder()
                .productName(productRequest.getProductName())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);

        log.info("Product Created");
        return product.getProductId();
    }

    public ProductResponse getProductById(long productId) {
        log.info("Get the product for productId: {}", productId);

        Product product
                = productRepository.findById(productId)
                .orElseThrow(
                        () -> new ProductServiceCustomException("Product with given id not found", "PRODUCT_NOT_FOUND"));

        ProductResponse productResponse = new ProductResponse();

        copyProperties(product, productResponse);

        return productResponse;
    }

    public void updateProduct(long productId, ProductRequest productRequest) {
        log.info("Update the product for productId: {}", productId);

        Product product
                = productRepository.findById(productId)
                .orElseThrow(
                        () -> new ProductServiceCustomException("Product with given id not found", "PRODUCT_NOT_FOUND"));

        productRepository.findById(productId)
                .ifPresent(existingProduct -> {
                    existingProduct.setProductName(productRequest.getProductName());
                    existingProduct.setPrice(productRequest.getPrice());
                    existingProduct.setQuantity(productRequest.getQuantity());

                    productRepository.save(existingProduct);
                });

        log.info("Product Quantity updated Successfully");
    }

    public void reduceQuantity(long productId, int quantity) {
        log.info("Reduce Quantity {} for Id: {}", quantity, productId);

        Product product
                = productRepository.findById(productId)
                .orElseThrow(() -> new ProductServiceCustomException(
                        "Product with given Id not found",
                        "PRODUCT_NOT_FOUND"
                ));

        if (product.getQuantity() < quantity) {
            throw new ProductServiceCustomException(
                    "Product does not have sufficient Quantity",
                    "INSUFFICIENT_QUANTITY"
            );
        }

        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
        log.info("Product Quantity updated Successfully");
    }


}
