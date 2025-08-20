package com.example.Dealer_vehicleApi.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Dealer_vehicleApi.Entity.Dealer.SubscriptionType;
import com.example.Dealer_vehicleApi.Entity.Vehicle;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v FROM Vehicle v WHERE v.dealer.subscriptionType = :subscriptionType")
    List<Vehicle> findByDealerSubscription(SubscriptionType subscriptionType);
}
