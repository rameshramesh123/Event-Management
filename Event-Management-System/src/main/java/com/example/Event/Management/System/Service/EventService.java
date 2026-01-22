package com.example.Event.Management.System.Service;

import com.example.Event.Management.System.Entity.Event;
import com.example.Event.Management.System.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    EventRepository repo;

    public List<Event> getAllEvents() {
        return repo.findAll();
    }

    public Event save(Event e) {
        return repo.save(e);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Event getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }
    public long countEvents() { return repo.count(); }

}

