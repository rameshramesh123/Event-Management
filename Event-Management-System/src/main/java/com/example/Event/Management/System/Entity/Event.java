package com.example.Event.Management.System.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private String location;
    private LocalDate eventDate;
    private int capacity;

    public Event(Long id, String title, String description, String location, LocalDate eventDate, int capacity) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.eventDate = eventDate;
        this.capacity = capacity;
    }

    public Event() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}