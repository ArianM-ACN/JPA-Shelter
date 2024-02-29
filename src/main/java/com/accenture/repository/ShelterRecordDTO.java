package com.accenture.repository;

import java.util.List;

public record ShelterRecordDTO(Long id, String name, String address, int capacity, List<AnimalEntity> animalsInShelter) {
}

