package com.accenture.controller;

import com.accenture.repository.AnimalEntity;
import com.accenture.repository.AnimalRecordDTO;
import com.accenture.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//gibt controller dtos zurück?
// mapper als bean? component

@RestController
public class AnimalController {

    private final AnimalService animalServiceImpl;

    @Autowired
    public AnimalController(AnimalService animalServiceImpl) {
        this.animalServiceImpl = animalServiceImpl;
    }

    @PostMapping("/api/animal/v1")
    public void createAnimal(@RequestBody AnimalRecordDTO animal){
        animalServiceImpl.create(animal);
    }

    @GetMapping("api/animal/v1/{animalID}")
    public Optional<AnimalRecordDTO> getAnimalById(@PathVariable("animalID") Long id){
        return animalServiceImpl.getAnimalbyId(id);
    }

    @GetMapping("api/animal/v1")
    public List<AnimalEntity> getAnimals(){
       return animalServiceImpl.getAnimals();
    }

    @DeleteMapping("api/animal/v1/{animalID}")
    public void deleteAnimal(@PathVariable("animalID") Long id){
        animalServiceImpl.deleteAnimal(id);
    }

    @PutMapping("api/animal/v1/{animalID}")
    public void updateAnimal(@PathVariable("animalID") Long id, @RequestBody AnimalRecordDTO animal){
        animalServiceImpl.updateAnimal(id, animal);
    }

    //
    @GetMapping("api/animal/{name}")
    public ResponseEntity<AnimalRecordDTO> getAnimalByName(@PathVariable("name") String name){
        return new ResponseEntity<>(animalServiceImpl.getByName(name), HttpStatus.OK);
    }

}
