package com.sougata.ecommerce.project.service;

import com.sougata.ecommerce.project.payload.OrderDTO;
import jakarta.transaction.Transactional;

public interface OrderService {

    @Transactional
    OrderDTO placeOrder(String emailId, Long addressId, String paymentMethod, String pgName, Long pgPaymentId, String pgStatus, String pgResponseMessage);
}
