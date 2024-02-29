package com.accenture.repository;

import jakarta.persistence.*;

@Entity
public class AdopterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String contact_info;
    @OneToOne
    private AnimalEntity adopted_animal;


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

    public String getContact_info() {
        return contact_info;
    }

    public void setContact_info(String contact_info) {
        this.contact_info = contact_info;
    }

    public AnimalEntity getAdopted_animal() {
        return adopted_animal;
    }

    public void setAdopted_animal(AnimalEntity adopted_animal) {
        this.adopted_animal = adopted_animal;
    }
}
