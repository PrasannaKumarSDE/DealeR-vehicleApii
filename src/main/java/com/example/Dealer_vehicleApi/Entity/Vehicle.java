package com.example.Dealer_vehicleApi.Entity;


import jakarta.persistence.*;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private Double price;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "dealer_id")
    private Dealer dealer;

    public enum Status {
        AVAILABLE, SOLD
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public Dealer getDealer() { return dealer; }
    public void setDealer(Dealer dealer) { this.dealer = dealer; }
}
