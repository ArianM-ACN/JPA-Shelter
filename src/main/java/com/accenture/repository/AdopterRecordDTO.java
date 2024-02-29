package com.accenture.repository;

public record AdopterRecordDTO(Long id, String name, String contact_info, AnimalEntity adopted_animal) { //Immer gleich nennen, sonst kanns nicht gemappt werden
}
