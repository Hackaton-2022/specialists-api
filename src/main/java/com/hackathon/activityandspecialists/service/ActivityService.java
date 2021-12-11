package com.hackathon.activityandspecialists.service;

import java.util.List;

import com.hackathon.activityandspecialists.entity.Activity;
import com.hackathon.activityandspecialists.exception.ApiRequestException;
import com.hackathon.activityandspecialists.repository.ActivityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService implements ActivityServiceInterface {

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public Activity saveActivity(Activity activity) {
        if (activityRepository.findById(activity.getId()) == null) {
            return activityRepository.save(activity);
        } else {
            throw new ApiRequestException("No se puede guardar la actividad con los datos especificados");
        }
    }

    @Override
    public List<Activity> getActivityList() {
        return activityRepository.findAll();
    }

    @Override
    public Activity getActivityById(Long id) {
        if (activityRepository.findById(id).get() != null) {
            return activityRepository.findById(id).get();
        } else {
            throw new ApiRequestException("No existe una actividad identificada con el id " + id);
        }
    }

    @Override
    public void deleteActivityById(Long id) {
        if (activityRepository.findById(id) != null) {
            activityRepository.deleteById(id);
        } else {
            throw new ApiRequestException("No existe una actividad identificada con el id " + id);
        }
    }

    @Override
    public Activity updateActivityById(Activity activity, Long id) {
        // obtains activity from db using id
        Activity activityFromDb = activityRepository.findById(id).get();
        // verifies wich field exists
        if (activity.getName() != null) {
            activityFromDb.setName(activity.getName());
        }
        if (activity.getAddress() != null) {
            activityFromDb.setAddress(activity.getAddress());
        }
        if (activity.getDate() != null) {
            activityFromDb.setDate(activity.getDate());
        }
        if (activity.getDescription() != null) {
            activityFromDb.setDescription(activity.getDescription());
        }
        return activityRepository.save(activityFromDb);
    }

}
