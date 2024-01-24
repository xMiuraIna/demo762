package com.example.demo762.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class MusicalInstrument {

    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "material")
    private String material;
    @Column(name = "amount")
    private Integer amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public MusicalInstrument(String name,String material, int amount) {
        this.name = name;
        this.material = material;
        this.amount = amount;
    }
}

