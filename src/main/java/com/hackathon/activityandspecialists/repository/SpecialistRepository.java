package com.hackathon.activityandspecialists.repository;

import com.hackathon.activityandspecialists.entity.Specialist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialistRepository extends JpaRepository<Specialist, Long> {
    /** Defines the methods used for connecting with the db */
}
