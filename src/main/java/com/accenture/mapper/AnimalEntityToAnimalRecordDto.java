package com.accenture.mapper;

import com.accenture.repository.AnimalEntity;
import com.accenture.repository.AnimalRecordDTO;
import org.springframework.stereotype.Component;

@Component
public class AnimalEntityToAnimalRecordDto implements Mapper<AnimalEntity, AnimalRecordDTO>{
    @Override
    public AnimalRecordDTO mapTo(AnimalEntity animalEntity) {
        return new AnimalRecordDTO(animalEntity.getId(), animalEntity.getName(), animalEntity.getSpecies(), animalEntity.getBreed(), animalEntity.getAge(), animalEntity.getGender());
    }
}
