package com.flightfinder.controller;

import com.flightfinder.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/countFlight")
    public String countFlight(@RequestParam String input) {
        if (!input.matches("[a-z]*")) { // Check if input contains only lowercase letters
            return "Error: Only lowercase letters are allowed.";
        }
        int count = flightService.calculateFlightOccurrences(input);
        return "Number of 'flight': " + count;
    }
}
