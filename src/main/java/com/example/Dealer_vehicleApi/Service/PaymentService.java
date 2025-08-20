package com.example.Dealer_vehicleApi.Service;


import org.springframework.stereotype.Service;

import com.example.Dealer_vehicleApi.Entity.Payment;
import com.example.Dealer_vehicleApi.Repository.PaymentRepository;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment initiatePayment(Payment payment) {
        payment.setStatus(Payment.Status.PENDING);
        Payment saved = paymentRepository.save(payment);

        new Thread(() -> {
            try {
                Thread.sleep(5000);
                saved.setStatus(Payment.Status.SUCCESS);
                paymentRepository.save(saved);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        return saved;
    }
}
