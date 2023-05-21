package com.coursepaper.CoursePaper.Entitities;

import jakarta.persistence.*;


@Entity
@Table(name="stock")
public class TissueStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tissue_id")
    private Tissue tissue;

    @Column(name = "length")
    private double length;

    public TissueStock(int id, Tissue tissue, int length) {
        this.id = id;
        this.tissue = tissue;
        this.length = length;
    }

    public TissueStock() {

    }

    public TissueStock(Tissue tissue, int length) {
        this.tissue = tissue;
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tissue getTissue() {
        return tissue;
    }

    public void setTissue(Tissue tissue) {
        this.tissue = tissue;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

}