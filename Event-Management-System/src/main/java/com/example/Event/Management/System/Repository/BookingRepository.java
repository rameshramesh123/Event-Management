package com.example.Event.Management.System.Repository;

import com.example.Event.Management.System.Entity.Booking;
import com.example.Event.Management.System.Entity.Event;
import com.example.Event.Management.System.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    boolean existsByUserAndEvent(User user, Event event);

    List<Booking> findByUser(User user);
}
