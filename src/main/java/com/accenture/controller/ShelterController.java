package com.accenture.controller;

import com.accenture.repository.ShelterRecordDTO;
import com.accenture.service.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShelterController {

    private ShelterService shelterService;

    @Autowired
    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    @PostMapping("api/shelter/v1")
    public void create(@RequestBody ShelterRecordDTO shelterRecordDTO){
        shelterService.create(shelterRecordDTO);
    }

    @GetMapping("api/shelter/v1")
    public void showShelters(){

    }
}
