package com.accenture.mapper;

import com.accenture.repository.AnimalEntity;
import com.accenture.repository.AnimalRecordDTO;
import org.springframework.stereotype.Component;

@Component //warum mapper component? -> damit bean wird?
public class AnimalRecordDtoToAnimalEntitiy implements Mapper<AnimalRecordDTO, AnimalEntity>{
    @Override
    public AnimalEntity mapTo(AnimalRecordDTO source) {
        AnimalEntity target = new AnimalEntity();
        target.setId(source.id());
        target.setAge(source.age());
        target.setBreed(source.breed());
        target.setName(source.name());
        target.setGender(source.gender());
        target.setSpecies(source.species());

        return target;
    }

}
