package com.example.Dealer_vehicleApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Dealer_vehicleApi.Entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
