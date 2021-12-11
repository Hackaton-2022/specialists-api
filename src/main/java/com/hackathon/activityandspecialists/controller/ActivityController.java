package com.hackathon.activityandspecialists.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hackathon.activityandspecialists.entity.Activity;
import com.hackathon.activityandspecialists.service.ActivityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityController {
    /** Controller for activities */

    @Autowired
    private ActivityService activityService;

    @GetMapping("api/activity/all")
    public List<Activity> getActivities() {
        return activityService.getActivityList();
    }

    @GetMapping("api/activity/id/{id}")
    public Activity getActivityById(@PathVariable("id") Long id) {
        return activityService.getActivityById(id);
    }

    @PostMapping("api/activity/create")
    public Activity saveActivity(@RequestBody Activity activity) {
        return activityService.saveActivity(activity);
    }

    @PutMapping("api/activity/id/{id}")
    public Activity updateActivityById(@RequestBody Activity activity, @PathVariable("id") Long id) {
        return activityService.updateActivityById(activity, id);
    }

    @DeleteMapping("api/activity/id/{id}")
    public Map<String, String> deleteActivityById(@PathVariable("id") Long id) {
        activityService.deleteActivityById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Actividad eliminada correctamente");
        return response;
    }
}
