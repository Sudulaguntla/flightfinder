package com.flightfinder.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FlightService {

    private static final String TARGET_WORD = "flight";

    public int calculateFlightOccurrences(String input) {
        // Count characters using a Map
        Map<Character, Integer> charCount = new HashMap<>();

        input.chars()
                .mapToObj(c -> (char) c)
                .forEach(c -> charCount.put(c, charCount.getOrDefault(c, 0) + 1));

        // Calculate the minimum number of times we can form the word "flight"
        return TARGET_WORD.chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .mapToInt(c -> charCount.getOrDefault(c, 0))
                .min()
                .orElse(0);
    }
}