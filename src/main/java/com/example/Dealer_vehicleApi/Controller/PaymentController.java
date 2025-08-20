package com.example.Dealer_vehicleApi.Controller;

import org.springframework.web.bind.annotation.*;

import com.example.Dealer_vehicleApi.Entity.Payment;
import com.example.Dealer_vehicleApi.Service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/initiate")
    public Payment initiate(@RequestBody Payment payment) {
        return paymentService.initiatePayment(payment);
    }
}

