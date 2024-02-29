package com.accenture.service;

import com.accenture.repository.AdopterRecordDTO;

import java.util.List;

public interface AdopterService {

    void create(AdopterRecordDTO record);

    AdopterRecordDTO getAdopter(Long id);

    void updateAdopterById(Long id, AdopterRecordDTO adopterRecordDTO);

    List<AdopterRecordDTO> getAllAdopters();

    List<AdopterRecordDTO> getAdoptByCity(String stadt);
}
