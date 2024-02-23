package com.dash.productservice.beans;

import lombok.Data;

@Data
public class ProductRequest {

    private String productName;
    private float price;
    private int quantity;
}
