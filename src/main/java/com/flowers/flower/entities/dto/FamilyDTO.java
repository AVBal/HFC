package com.flowers.flower.entities.dto;

public class FamilyDTO {

    private long id;

    private String name;

    private String careFeatures;

    public FamilyDTO() {
    }

    public FamilyDTO(long id, String name, String careFeatures) {
        this.id = id;
        this.name = name;
        this.careFeatures = careFeatures;
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

    public String getCareFeatures() {
        return careFeatures;
    }

    public void setCareFeatures(String careFeatures) {
        this.careFeatures = careFeatures;
    }
}
