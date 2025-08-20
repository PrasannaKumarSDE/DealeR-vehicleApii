package com.example.Dealer_vehicleApi.Entity;



import jakarta.persistence.*;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long dealerId;
    private Double amount;
    private String method;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        PENDING, SUCCESS
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getDealerId() { return dealerId; }
    public void setDealerId(Long dealerId) { this.dealerId = dealerId; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
