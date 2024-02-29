package com.accenture.service;

import com.accenture.mapper.AdopterMapperImpl;
import com.accenture.repository.AdopterEntity;
import com.accenture.repository.AdopterRecordDTO;
import com.accenture.repository.AdopterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdopterServiceImpl implements AdopterService{

    private final AdopterRepository adopterRepository;

    private final AdopterMapperImpl adopterMapper;
    @Autowired
    public AdopterServiceImpl(AdopterRepository adopterRepository, AdopterMapperImpl adopterMapper) {
        this.adopterRepository = adopterRepository;
        this.adopterMapper=adopterMapper;
    }

    @Override
    public void create(AdopterRecordDTO adopter) {
        AdopterEntity target = adopterMapper.mapToEntity(adopter);
        adopterRepository.save(target);

    }

    @Override
    public AdopterRecordDTO getAdopter(Long id) {
        AdopterRecordDTO adopterRecordDTO = adopterMapper.mapToDto(adopterRepository.findById(id).orElse(null));
        return adopterRecordDTO;
    }

    @Override
    public void updateAdopterById(Long id, AdopterRecordDTO adopterRecordDTO) {
        AdopterEntity adopter = adopterMapper.mapToEntity(adopterRecordDTO);
        adopter.setId(id);
        adopterRepository.save(adopter);

    }

    @Override
    public List<AdopterRecordDTO> getAllAdopters() {
        List<AdopterRecordDTO> list = new ArrayList<>();
        List<AdopterEntity> adopList = adopterRepository.findAll();
        for (AdopterEntity adopterEntity : adopList) {
            list.add(adopterMapper.mapToDto(adopterEntity));
        }

        return list;
    }

    @Override
    public List<AdopterRecordDTO> getAdoptByCity(String stadt) {
        List<AdopterEntity> filteredAdopters = adopterRepository.findByCity(stadt);
        return filteredAdopters.stream().map(adopterMapper::mapToDto).toList();
    }
}
