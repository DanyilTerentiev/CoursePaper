package com.coursepaper.CoursePaper.DTOs;

public class ModelDTO {
    private int id;
    private int tissueId;
    private String name;
    private int orderId;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTissueId() {
        return tissueId;
    }

    public void setTissueId(int tissueId) {
        this.tissueId = tissueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
