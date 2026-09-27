package com.sougata.ecommerce.project.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {

    private Long addressId;
    private String pgPaymentId;
    private String pgName;
    private String pgStatus;
    private String paymentMethod;
    private String pgResponseMessage;
}
