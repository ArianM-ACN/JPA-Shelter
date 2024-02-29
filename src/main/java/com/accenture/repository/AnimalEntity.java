package com.accenture.repository;

import jakarta.persistence.*;

@Entity
public class AnimalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    //wrapper
    private String name;
    private String species;
    private String breed;
    private int age;
    private String gender;
    @ManyToOne
    @JoinColumn(name="shelter_id")
    private ShelterEntity shelterEntity;

    //hibernate schaut nur felder an
    // POJO java bean - spring bean beliebige java klassen die unter verwaltung von spring
    // für jpa entities JAVA Beans (leere Konstruktoren) -> Datenklassen nicht zu Spring
    // Spring alles zu Repository / Service / Controller, aber nie Klassen die durchgereicht werden (bspw. Animal)

    // ask default constructor, error without
    public AnimalEntity(){

    }

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

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    //private DateTime arrivaldate;


}
