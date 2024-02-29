package com.accenture.service;

import com.accenture.mapper.AnimalEntityToAnimalRecordDto;
import com.accenture.mapper.AnimalRecordDtoToAnimalEntitiy;
import com.accenture.repository.AnimalEntity;
import com.accenture.repository.AnimalRecordDTO;
import com.accenture.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService{

    private final AnimalRepository animalRepository;

    private final AnimalEntityToAnimalRecordDto dtoMapper;
    private final AnimalRecordDtoToAnimalEntitiy entityMapper;

    @Autowired
    public AnimalServiceImpl(AnimalRepository animalRepository, AnimalEntityToAnimalRecordDto dtoMapper, AnimalRecordDtoToAnimalEntitiy entityMapper) {
        this.animalRepository = animalRepository;
        this.dtoMapper = dtoMapper;
        this.entityMapper = entityMapper;
    }

    @Override
    public void create(AnimalRecordDTO animal) {
        AnimalEntity animalEntity = entityMapper.mapTo(animal);
        animalRepository.save(animalEntity);
    }

    @Override
    public List<AnimalEntity> getAnimals() {
       return animalRepository.findAll();
    }

    @Override
    public Optional<AnimalRecordDTO> getAnimalbyId(Long id) {
        AnimalRecordDTO record = dtoMapper.mapTo(animalRepository.findById(id).orElse(null));
        return Optional.ofNullable(record);
    }

    @Override
    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }

    @Override
    public void updateAnimal(Long id, AnimalRecordDTO animal) {

        AnimalEntity target = entityMapper.mapTo(animal);
        target.setId(id);
        //AnimalEntity currentAnimal = animalRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found"));
        animalRepository.save(target);
    }

    @Override
    public AnimalRecordDTO getByName(String name) {
        AnimalRecordDTO record = dtoMapper.mapTo(animalRepository.findByName(name).orElse(null));
        return record;
    }
}
