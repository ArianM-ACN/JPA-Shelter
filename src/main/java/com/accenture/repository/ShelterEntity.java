package com.accenture.repository;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class ShelterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;

    private int capacity;

    @OneToMany
    @JoinColumn(name="shelter_id")// perhaps manyToOne from adopter and animal
    private List<AnimalEntity> animalsInShelter;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<AnimalEntity> getAnimalsInShelter() {
        return animalsInShelter;
    }

    public void setAnimalsInShelter(List<AnimalEntity> animalsInShelter) {
        this.animalsInShelter = animalsInShelter;
    }
}

