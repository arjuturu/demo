package com.user.service.controller;


import com.user.service.entity.Mood;
import com.user.service.exception.RecommendationException;
import com.user.service.service.RecommendationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/recommendation")
@Slf4j
public class RecommendationController {

    @Autowired
    private RecommendationService service;

    @PostMapping("/mood-logging")
    public ResponseEntity<String> logMood(@RequestBody Mood mood) {
        String result = service.saveMood(mood);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getAll")
    public List<Mood> getAll() {
        return service.getAll();
    }


    @GetMapping("/get-mood/{customerId}")
    public ResponseEntity<List<Mood>> getCustomerData(@PathVariable String customerId) {

        try {
            List<Mood> moods = service.getMoodRecommendationsById(customerId);
            return ResponseEntity.ok(moods);
        } catch (Exception e) {
            throw new RecommendationException("Exception Occurred while retrieving the customer moods");
        }
    }


 /*   @GetMapping("/wellness")
    public ResponseEntity<String> getWellnessRecommendation(@RequestParam String userId) {
        return ResponseEntity.ok("");
    }

    @PostMapping("/consultation")
    public ResponseEntity<String> bookConsultation(@RequestBody String request) {
        return ResponseEntity.ok("Consultation booked for ");
    }*/


}
