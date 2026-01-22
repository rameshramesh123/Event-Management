package com.example.Event.Management.System.Service;

import com.example.Event.Management.System.Entity.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {

    void bookEvent(Long eventId, String email);

    List<Booking> getBookingsByEmail(String email);

    long getBookingCountByEmail(String email);
}
