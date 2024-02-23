package com.dash.productservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PRODUCT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRICE")
    private float price;

    @Column(name = "QUANTITY")
    private int quantity;
}
