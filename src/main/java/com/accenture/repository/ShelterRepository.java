package com.accenture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelterRepository extends JpaRepository<ShelterEntity, Long> {
}
