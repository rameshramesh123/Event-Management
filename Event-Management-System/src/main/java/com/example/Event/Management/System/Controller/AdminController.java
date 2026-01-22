package com.example.Event.Management.System.Controller;

import com.example.Event.Management.System.Entity.Booking;
import com.example.Event.Management.System.Entity.Event;
import com.example.Event.Management.System.Entity.User;
import com.example.Event.Management.System.Repository.BookingRepository;
import com.example.Event.Management.System.Repository.UserRepository;
import com.example.Event.Management.System.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EventService eventService;

    @Autowired
    UserServiceImpl userServiceImp;

    @Autowired
    BookingServiceImpl bookingServiceImp;

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping("/dashboard")
    public String adminDashboard(Model model) {
        model.addAttribute("totalEvents", eventService.countEvents());
        model.addAttribute("totalUsers", userServiceImp.countUsers());
        model.addAttribute("bookedUsersCount", bookingServiceImp.countBookings());
        model.addAttribute("events", eventService.getAllEvents());
//        model.addAttribute("bookings", bookingService.getAllBookings());
        List<Booking> bookings = bookingRepository.findAll();
        model.addAttribute("bookings", bookings);

        return "admin-dashboard";
    }

    @GetMapping("/add-event")
    public String addEventForm(Model model) {
        model.addAttribute("event", new Event());
        return "add-event";
    }
    @PostMapping("/save-event")
    public String saveEvent(@ModelAttribute Event event) {
        eventService.save(event);
        return "redirect:/admin/dashboard";
    }
    @GetMapping("/edit/{id}")
    public String editEvent(@PathVariable Long id, Model model) {
        Event event = eventService.getById(id);
        model.addAttribute("event", event);
        return "edit-event";
    }
    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.delete(id);
        return "redirect:/admin/dashboard";
    }
}


