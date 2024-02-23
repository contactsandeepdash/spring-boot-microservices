package com.dash.productservice.beans;

import lombok.Data;

import java.util.List;

@Data
public class ProductResponseList {
    List<ProductResponse> productResponses;
}
