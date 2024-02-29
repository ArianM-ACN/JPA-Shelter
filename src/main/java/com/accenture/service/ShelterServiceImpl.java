package com.accenture.service;

import com.accenture.mapper.ShelterMapper;
import com.accenture.repository.ShelterEntity;
import com.accenture.repository.ShelterRecordDTO;
import com.accenture.repository.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShelterServiceImpl implements ShelterService{

    private ShelterRepository shelterRepository;
    private ShelterMapper shelterMapper;

    @Autowired
    public ShelterServiceImpl(ShelterRepository shelterRepository, ShelterMapper shelterMapper) {
        this.shelterRepository = shelterRepository;
        this.shelterMapper = shelterMapper;
    }

    public void create(ShelterRecordDTO shelterRecordDTO){
        ShelterEntity shelterEntity = shelterMapper.mapToEntity(shelterRecordDTO);
        shelterRepository.save(shelterEntity);
    }
}
