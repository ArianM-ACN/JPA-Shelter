package com.accenture.mapper;

import com.accenture.repository.AdopterEntity;
import com.accenture.repository.AdopterRecordDTO;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AdopterMapper {

    AdopterEntity mapToEntity(AdopterRecordDTO adopter);
    AdopterRecordDTO mapToDto(AdopterEntity adopter);
}
