package com.dash.cloudgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @GetMapping("/orderServiceFallBack")
    public Mono<String> orderServiceFallback() {
        return Mono.just("Order Service is down!");
    }

    @GetMapping("/paymentServiceFallBack")
    public Mono<String> paymentServiceFallback() {
        return Mono.just("Payment Service is down!");
    }

    @GetMapping("/productServiceFallBack")
    public Mono<String> productServiceFallback() {
        return Mono.just("Product Service is down!");
    }

}
