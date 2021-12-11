package com.hackathon.activityandspecialists.repository;

import com.hackathon.activityandspecialists.entity.Activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    /** Defines the methods used for connecting with the db */
}
