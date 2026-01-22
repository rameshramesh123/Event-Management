package com.example.Event.Management.System.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    private Long id;


    @ManyToOne
    private User user;


    @ManyToOne
    private Event event;


    private LocalDateTime bookingDate;

    public Booking(Long id, User user, Event event, LocalDateTime bookingDate) {
        this.id = id;
        this.user = user;
        this.event = event;
        this.bookingDate = bookingDate;
    }

    public Booking() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }
}