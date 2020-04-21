package com.flowers.flower.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CARE")
public class Care {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "care_features", nullable = false, unique = true)
    private String careFeatures;

    @OneToMany(mappedBy = "careFeature", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Family> families;

    public Care() {
    }

    public Care(String careFeatures) {
        this.careFeatures = careFeatures;
    }

    public Care(String careFeatures, List<Family> families) {
        this.careFeatures = careFeatures;
        this.families = families;
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

    public List<Family> getFamilies() {
        return families;
    }

    public void setFamilies(List<Family> families) {
        this.families = families;
    }
}
