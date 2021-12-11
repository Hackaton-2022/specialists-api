package com.hackathon.activityandspecialists.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "t_activities")
public class Activity {
    /** Entity model for activities */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
    private String date;
    @JsonFormat(pattern = "HH:mm", shape = Shape.STRING)
    private String time;
    private String description;

    public Activity() {
    }

    public Activity(Long id, String name, String address, String date, String time, String description) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", address='" + getAddress() + "'" +
                ", date='" + getDate() + "'" +
                ", time='" + getTime() + "'" +
                ", description='" + getDescription() + "'" +
                "}";
    }
}
