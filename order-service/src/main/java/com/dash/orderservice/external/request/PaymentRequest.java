package com.dash.orderservice.external.request;

import com.dash.orderservice.beans.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {

    private long orderId;
    private float amount;
    private String referenceNumber;
    private PaymentMode paymentMode;

}
