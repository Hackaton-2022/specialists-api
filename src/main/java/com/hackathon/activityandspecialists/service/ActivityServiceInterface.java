package com.hackathon.activityandspecialists.service;

import java.util.List;

import com.hackathon.activityandspecialists.entity.Activity;

public interface ActivityServiceInterface {
    /** Defines methos used for service */

    public Activity saveActivity(Activity activity);

    public List<Activity> getActivityList();

    public Activity getActivityById(Long id);

    public void deleteActivityById(Long id);

    public Activity updateActivityById(Activity activity, Long id);
}
