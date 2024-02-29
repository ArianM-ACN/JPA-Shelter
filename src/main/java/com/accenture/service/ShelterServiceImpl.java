package com.accenture.service;

import com.accenture.mapper.AnimalEntityToAnimalRecordDto;
import com.accenture.mapper.AnimalRecordDtoToAnimalEntitiy;
import com.accenture.mapper.ShelterMapper;
import com.accenture.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelterServiceImpl implements ShelterService{

    private ShelterRepository shelterRepository;
    private ShelterMapper shelterMapper;

    private AnimalEntityToAnimalRecordDto entMap;
    private AnimalRecordDtoToAnimalEntitiy dtoMap;

    private AnimalRepository animalRepository;

    @Autowired
    public ShelterServiceImpl(ShelterRepository shelterRepository, ShelterMapper shelterMapper, AnimalEntityToAnimalRecordDto entMap, AnimalRecordDtoToAnimalEntitiy dtoMap, AnimalRepository animalRepository) {
        this.shelterRepository = shelterRepository;
        this.shelterMapper = shelterMapper;
        this.entMap=entMap;
        this.dtoMap=dtoMap;
        this.animalRepository=animalRepository;
    }

    public void create(ShelterRecordDTO shelterRecordDTO){
        ShelterEntity shelterEntity = shelterMapper.mapToEntity(shelterRecordDTO);
        shelterRepository.save(shelterEntity);
    }

    @Override
    public List<ShelterRecordDTO> allShelters() {
        List<ShelterEntity> all = shelterRepository.findAll();
        List<ShelterRecordDTO> transfList = all.stream().map(shelterMapper::mapToDto).toList();
        return transfList;
    }

    @Override
    public void addAnimalsToShelter(List<AnimalRecordDTO> animalRecordDTOS, Long id) {
        ShelterEntity shelterEntity = shelterRepository.findById(id).orElse(null);
        animalRecordDTOS.stream()
                .map(p -> dtoMap.mapTo(p))
                .map(animalRepository::save)
                .forEach(a->shelterEntity.getAnimalsInShelter().add(a));
        //List<AnimalEntity> animalsFromList = shelterEntity.getAnimalsInShelter(); //get all animals from found shelter
        //animalsFromList.addAll(animals.stream().map(p->animalRepository.save(p)).toList()); //add all animals to already existing animals
        //shelterEntity.setAnimalsInShelter(animalsFromList);  //set all existing and new animals of our shelter //redundant
        shelterRepository.save(shelterEntity);
    }


}
