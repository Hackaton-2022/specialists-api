package com.hackathon.activityandspecialists.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hackathon.activityandspecialists.entity.Specialist;
import com.hackathon.activityandspecialists.service.SpecialistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpecialistController {
    /** controller for specialists */
    @Autowired
    private SpecialistService specialistService;

    @GetMapping("api/specialist/all")
    public List<Specialist> getSpecialists() {
        return specialistService.getSpecialistList();
    }

    @GetMapping("api/specialist/id/{id}")
    public Specialist getSpecialistById(@PathVariable("id") Long id) {
        return specialistService.getSpecialistById(id);
    }

    @PostMapping("api/specialist/create")
    public Specialist saveSpecialist(@RequestBody Specialist specialist) {
        return specialistService.saveSpecialist(specialist);
    }

    @PutMapping("api/specialist/id/{id}")
    public Specialist updateSpecialistById(@RequestBody Specialist specialist, @PathVariable("id") Long id) {
        return specialistService.updateSpecialistById(specialist, id);
    }

    @DeleteMapping("api/specialist/id/{id}")
    public Map<String, String> deleteSpecialistById(@PathVariable("id") Long id) {
        specialistService.deleteSpecialistById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Especialista borrado correctamente");
        return response;
    }
}
