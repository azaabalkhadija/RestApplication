package com.example.demorestapplication;

public class Order {

    private Long id;
    private String customer;
    private Double amount;

    public Order() {
    }

    public Order(Long id, String customer, Double amount) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }

    // Getters & setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}

