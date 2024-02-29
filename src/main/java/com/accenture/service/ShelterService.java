package com.accenture.service;

import com.accenture.repository.ShelterRecordDTO;

import java.util.List;

public interface ShelterService {
    void create(ShelterRecordDTO shelterRecordDTO);

    List<ShelterRecordDTO> allShelters();
}
