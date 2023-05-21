package com.coursepaper.CoursePaper.Entitities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "model")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private int id;
    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "tissue_id", referencedColumnName = "tissue_id")
    private Tissue tissue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "price")
    private double price;

    public Model(int id, String name, Tissue tissue, Order order, double price) {
        this.id = id;
        this.name = name;
        this.tissue = tissue;
        this.order = order;
        this.price = price;
    }

    public Model() {

    }

    public Model(String name, Tissue tissue, Order order, double price) {
        this.name = name;
        this.tissue = tissue;
        this.order = order;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tissue getTissue() {
        return tissue;
    }

    public void setTissue(Tissue tissue) {
        this.tissue = tissue;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
