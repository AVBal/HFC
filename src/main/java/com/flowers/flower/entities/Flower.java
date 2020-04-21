package com.flowers.flower.entities;

import javax.persistence.*;

@Entity
@Table(name = "FLOWER")
public class Flower {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @Column(name = "photo_path")
    private String photoPath;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private double price;

    public Flower() {
    }

    public Flower(String name, Family family, String photoPath, String color, double price) {
        this.name = name;
        this.family = family;
        this.photoPath = photoPath;
        this.color = color;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }
}
