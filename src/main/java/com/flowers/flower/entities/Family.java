package com.flowers.flower.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FAMILY")
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "family", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Flower> flowers;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "care_id", nullable = false)
    private Care careFeature;

    public Family() {
    }

    public Family(String name, Care careFeature) {
        this.name = name;
        this.careFeature = careFeature;
    }

    public Family(String name, List<Flower> flowers, Care careFeature) {
        this.name = name;
        this.flowers = flowers;
        this.careFeature = careFeature;
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

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }

    public Care getCareFeature() {
        return careFeature;
    }

    public void setCareFeature(Care careFeature) {
        this.careFeature = careFeature;
    }
}
