package com.example.Event.Management.System.Controller;

import com.example.Event.Management.System.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/events")
public class EventController {
    @Autowired
    EventService service;


    @GetMapping
    public String list(Model model){
        model.addAttribute("events", service.getAllEvents());
        return "events";
    }
}
