package com.example.Event.Management.System.Repository;

import com.example.Event.Management.System.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    // Events NOT booked by a user
    @Query("""
        SELECT e FROM Event e
        WHERE e.id NOT IN (
            SELECT b.event.id FROM Booking b WHERE b.user.id = :userId
        )
    """)
    List<Event> findEventsNotBookedByUser(@Param("userId") Long userId);
}
