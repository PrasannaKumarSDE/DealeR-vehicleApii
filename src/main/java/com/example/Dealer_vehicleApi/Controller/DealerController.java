package com.example.Dealer_vehicleApi.Controller;


import org.springframework.web.bind.annotation.*;

import com.example.Dealer_vehicleApi.Entity.Dealer;
import com.example.Dealer_vehicleApi.Repository.DealerRepository;

import java.util.List;

@RestController
@RequestMapping("/api/dealers")
public class DealerController {

    private final DealerRepository dealerRepository;

    public DealerController(DealerRepository dealerRepository) {
        this.dealerRepository = dealerRepository;
    }

    @PostMapping
    public Dealer create(@RequestBody Dealer dealer) {
        return dealerRepository.save(dealer);
    }

    @GetMapping
    public List<Dealer> getAll() {
        return dealerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Dealer getById(@PathVariable Long id) {
        return dealerRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Dealer update(@PathVariable Long id, @RequestBody Dealer updated) {
        Dealer dealer = dealerRepository.findById(id).orElseThrow();
        dealer.setName(updated.getName());
        dealer.setEmail(updated.getEmail());
        dealer.setSubscriptionType(updated.getSubscriptionType());
        return dealerRepository.save(dealer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        dealerRepository.deleteById(id);
    }
}
