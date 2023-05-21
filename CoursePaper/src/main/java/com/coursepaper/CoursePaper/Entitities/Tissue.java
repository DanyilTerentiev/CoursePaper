package com.coursepaper.CoursePaper.Entitities;

import jakarta.persistence.*;

@Entity
@Table(name="tissue")
public class Tissue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tissue_id")
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "provider")
    private String provider;
    @Column(name = "width")
    private double width;
    @Column(name = "price")
    private double price;

    public Tissue(String name, String provider, double width, double price) {
        this.name = name;
        this.provider = provider;
        this.width = width;
        this.price = price;
    }

    public Tissue() {

    }

    public Tissue(int id, String name, String provider, double width, double price) {
        this.id = id;
        this.name = name;
        this.provider = provider;
        this.width = width;
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

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tissue{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", provider='" + provider + '\'' +
                ", width='" + width + '\'' +
                ", price=" + price +
                '}';
    }
}
