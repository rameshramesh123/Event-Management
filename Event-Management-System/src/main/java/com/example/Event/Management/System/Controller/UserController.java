package com.example.Event.Management.System.Controller;

import com.example.Event.Management.System.Entity.Booking;
import com.example.Event.Management.System.Entity.Event;
import com.example.Event.Management.System.Entity.User;
import com.example.Event.Management.System.Repository.BookingRepository;
import com.example.Event.Management.System.Repository.EventRepository;
import com.example.Event.Management.System.Repository.UserRepository;
import com.example.Event.Management.System.Service.BookingService;
import com.example.Event.Management.System.Service.EventService;
import com.example.Event.Management.System.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private EventService eventService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private BookingRepository bookingRepository;

    // ================= DASHBOARD =================
    @GetMapping("/dashboard")
    public String dashboard(Model model,
                            @AuthenticationPrincipal UserDetails userDetails) {

        User user = userService.findByEmail(userDetails.getUsername());

        model.addAttribute("userName", user.getName());
        model.addAttribute("email", user.getEmail());

        return "user-dashboard";
    }

    // ================= AVAILABLE EVENTS =================
    @GetMapping("/events")
    public String availableEvents(Model model, Principal principal) {

        User user = userRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Event> events = eventRepository.findAll();

        // get booked event IDs
        List<Long> bookedEventIds = bookingRepository
                .findByUser(user)
                .stream()
                .map(b -> b.getEvent().getId())
                .toList();

        model.addAttribute("events", events);
        model.addAttribute("bookedEventIds", bookedEventIds);

        return "events";
    }

    // ================= BOOK EVENT =================
    @GetMapping("/book/{id}")
    public String bookEvent(@PathVariable Long id,
                            Principal principal) {

        bookingService.bookEvent(id, principal.getName());
        return "redirect:/user/events";
    }

    // ================= BOOKED EVENTS =================
    @GetMapping("/booked-events")
    public String bookedEvents(Model model, Principal principal) {

        User user = userRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Booking> bookings = bookingRepository.findByUser(user);

        model.addAttribute("bookings", bookings);
        return "booked-events";
    }
}
