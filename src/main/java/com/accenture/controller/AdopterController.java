package com.accenture.controller;

import com.accenture.repository.AdopterRecordDTO;
import com.accenture.repository.AnimalRecordDTO;
import com.accenture.service.AdopterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AdopterController {
    private final AdopterService adopterServiceImpl;

    @Autowired
    public AdopterController(AdopterService adopterServiceImpl) {
        this.adopterServiceImpl = adopterServiceImpl;
    }


    @PostMapping("/api/adopter/v1")
    public void create(@RequestBody AdopterRecordDTO adopter){
        adopterServiceImpl.create(adopter);

    }

    @GetMapping("api/adopter/v1/{adopterID}")
    public AdopterRecordDTO getAdopterById(@PathVariable("adopterID") Long id){
        return adopterServiceImpl.getAdopter(id);
    }

    @GetMapping("/api/adopter/v1")
    public List<AdopterRecordDTO> getAdopters(){
        return adopterServiceImpl.getAllAdopters();
    }

    @PutMapping(value = "api/adopter/v1", params = "id")
    public void updateAdopter(@RequestParam Long id, @RequestBody AdopterRecordDTO adopter){
        adopterServiceImpl.updateAdopterById(id, adopter);
    }
}
