package com.flowers.flower.entities.dto;

public class FlowerDTO {

    private long id;

    private String name;

    private String family;

    private String photoPath;

    private String color;

    private double price;

    private String care;

    public FlowerDTO() {
    }

    public FlowerDTO(long id, String name, String family, String photoPath, String color, double price, String care) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.photoPath = photoPath;
        this.color = color;
        this.price = price;
        this.care = care;
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

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
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

    public String getCare() {
        return care;
    }

    public void setCare(String care) {
        this.care = care;
    }
}
