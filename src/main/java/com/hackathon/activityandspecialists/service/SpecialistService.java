package com.hackathon.activityandspecialists.service;

import java.util.List;

import com.hackathon.activityandspecialists.entity.Specialist;
import com.hackathon.activityandspecialists.exception.ApiRequestException;
import com.hackathon.activityandspecialists.repository.SpecialistRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialistService implements SpecialistServiceInterface {

    @Autowired
    private SpecialistRepository specialistRepository;

    @Override
    public Specialist saveSpecialist(Specialist specialist) {
        if (specialistRepository.findById(specialist.getId()).get() == null) {
            return specialistRepository.save(specialist);
        } else {
            throw new ApiRequestException("No es posible guardar el especialista con los datos indicados");
        }
    }

    @Override
    public List<Specialist> getSpecialistList() {
        return specialistRepository.findAll();
    }

    @Override
    public Specialist getSpecialistById(Long id) {
        if (specialistRepository.findById(id).get() != null) {
            return specialistRepository.findById(id).get();
        } else {
            throw new ApiRequestException("No existe un especialista identificado con el id " + id);
        }
    }

    @Override
    public void deleteSpecialistById(Long id) {
        if (specialistRepository.findById(id).get() != null) {
            specialistRepository.deleteById(id);
        } else {
            throw new ApiRequestException("No existe un especialista identificado con el id " + id);
        }

    }

    @Override
    public Specialist updateSpecialistById(Specialist specialist, Long id) {
        // obtains activity from db using id
        Specialist specialistFromDb = specialistRepository.findById(id).get();
        // verifies wich field exists
        if (specialist.getName() != null) {
            specialistFromDb.setName(specialist.getName());
        }
        if (specialist.getLast_name() != null) {
            specialistFromDb.setLast_name(specialist.getLast_name());
        }
        if (specialist.getAddress() != null) {
            specialistFromDb.setAddress(specialist.getAddress());
        }
        if (specialist.getPhone() != null) {
            specialistFromDb.setPhone(specialist.getPhone());
        }
        if (specialist.getEmail() != null) {
            specialistFromDb.setEmail(specialist.getEmail());
        }
        if (specialist.getProfession() != null) {
            specialistFromDb.setProfession(specialist.getProfession());
        }
        return specialistRepository.save(specialistFromDb);
    }

}
