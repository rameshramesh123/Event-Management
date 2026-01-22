package com.example.Event.Management.System.Service;

import com.example.Event.Management.System.Entity.Booking;
import com.example.Event.Management.System.Entity.Event;
import com.example.Event.Management.System.Entity.User;
import com.example.Event.Management.System.Repository.BookingRepository;
import com.example.Event.Management.System.Repository.EventRepository;
import com.example.Event.Management.System.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    // ================= BOOK EVENT =================
    @Override
    public void bookEvent(Long eventId, String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        // prevent duplicate booking
        if (bookingRepository.existsByUserAndEvent(user, event)) {
            return;
        }

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setEvent(event);
        booking.setBookingDate(LocalDateTime.now());

        bookingRepository.save(booking);
    }

    // ================= GET BOOKINGS =================
    @Override
    public List<Booking> getBookingsByEmail(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return bookingRepository.findByUser(user);
    }

    // ================= BOOKING COUNT =================
    @Override
    public long getBookingCountByEmail(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return bookingRepository.findByUser(user).size();
    }

    public long countBookings() { return bookingRepository.count(); }

}
