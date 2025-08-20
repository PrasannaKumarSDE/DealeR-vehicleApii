package com.example.Dealer_vehicleApi.Controller;

import org.springframework.web.bind.annotation.*;

import com.example.Dealer_vehicleApi.Entity.Dealer.SubscriptionType;
import com.example.Dealer_vehicleApi.Entity.Vehicle;
import com.example.Dealer_vehicleApi.Repository.VehicleRepository;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleRepository vehicleRepository;

    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @PostMapping
    public Vehicle create(@RequestBody Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @GetMapping
    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Vehicle getById(@PathVariable Long id) {
        return vehicleRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Vehicle update(@PathVariable Long id, @RequestBody Vehicle updated) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow();
        vehicle.setModel(updated.getModel());
        vehicle.setPrice(updated.getPrice());
        vehicle.setStatus(updated.getStatus());
        return vehicleRepository.save(vehicle);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        vehicleRepository.deleteById(id);
    }

    @GetMapping("/premium")
    public List<Vehicle> getPremiumVehicles() {
        return vehicleRepository.findByDealerSubscription(SubscriptionType.PREMIUM);
    }
}
