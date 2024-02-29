package com.accenture.service;

import com.accenture.repository.ShelterRecordDTO;

public interface ShelterService {
    void create(ShelterRecordDTO shelterRecordDTO);

    void showAllShelters();
}
