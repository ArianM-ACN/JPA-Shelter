package com.accenture.mapper;


import com.accenture.repository.AdopterEntity;
import com.accenture.repository.AdopterRecordDTO;
import com.accenture.repository.ShelterEntity;
import com.accenture.repository.ShelterRecordDTO;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)

public interface ShelterMapper {

    ShelterEntity mapToEntity(ShelterRecordDTO shelterRecordDTO);
    ShelterRecordDTO mapToDto(ShelterEntity entity);
}
