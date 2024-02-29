package com.accenture.service;

import com.accenture.repository.AnimalEntity;
import com.accenture.repository.AnimalRecordDTO;

import java.util.List;
import java.util.Optional;

public interface AnimalService {

    void create(AnimalRecordDTO animal);

    List<AnimalEntity> getAnimals();

    Optional<AnimalRecordDTO> getAnimalbyId(Long id);

    void deleteAnimal(Long id);

    void updateAnimal(Long id, AnimalRecordDTO animal);

    AnimalRecordDTO getByName(String name);
}
