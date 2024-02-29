package com.accenture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdopterRepository extends JpaRepository<AdopterEntity, Long> {

    @Query("Select a from AdopterEntity a where a.contact_info = :city")
    List<AdopterEntity> findByCity(@Param("city") String city);
}
