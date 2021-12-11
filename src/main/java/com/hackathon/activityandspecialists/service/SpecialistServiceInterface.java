package com.hackathon.activityandspecialists.service;

import java.util.List;

import com.hackathon.activityandspecialists.entity.Specialist;

public interface SpecialistServiceInterface {
    /** Defines methos used for service */

    public Specialist saveSpecialist(Specialist specialist);

    public List<Specialist> getSpecialistList();

    public Specialist getSpecialistById(Long id);

    public void deleteSpecialistById(Long id);

    public Specialist updateSpecialistById(Specialist specialist, Long id);
}
