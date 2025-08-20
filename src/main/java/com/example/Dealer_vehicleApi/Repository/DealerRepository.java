package com.example.Dealer_vehicleApi.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Dealer_vehicleApi.Entity.Dealer;

public interface DealerRepository extends JpaRepository<Dealer, Long> {
}
