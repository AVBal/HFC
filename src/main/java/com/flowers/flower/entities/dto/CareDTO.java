package com.flowers.flower.entities.dto;

public class CareDTO {

    private int id;

    private String careFeatures;

    public CareDTO() {
    }

    public CareDTO(int id, String careFeatures) {
        this.id = id;
        this.careFeatures = careFeatures;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCareFeatures() {
        return careFeatures;
    }

    public void setCareFeatures(String careFeatures) {
        this.careFeatures = careFeatures;
    }
}
