package com.swe.challenge.mealkakis.controller;

import com.swe.challenge.mealkakis.model.entity.RestaurantSubmission;
import com.swe.challenge.mealkakis.model.entity.Session;
import com.swe.challenge.mealkakis.service.RestaurantSubmissionService;
import com.swe.challenge.mealkakis.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
@RequestMapping("/api/sessions")
public class SessionController {
    private final SessionService sessionService;
    private final RestaurantSubmissionService restaurantSubmissionService;

    @Autowired
    public SessionController(SessionService sessionService, RestaurantSubmissionService restaurantSubmissionService) {
        this.sessionService = sessionService;
        this.restaurantSubmissionService = restaurantSubmissionService;
    }

    @CrossOrigin
    @PostMapping("/initiate")
    public Session createSession() {
        return sessionService.createSession();
    }
    @CrossOrigin
    @PostMapping("/{sessionId}/join")
    public List<RestaurantSubmission> joinSession(@PathVariable Long sessionId) {
        return restaurantSubmissionService.getSubmissionsBySession(sessionId);
    }

    @CrossOrigin
    @PostMapping("/{sessionId}/end")
    public Session endSession(@PathVariable Long sessionId) {
        return sessionService.endSession(sessionId);
    }

    @CrossOrigin
    @PostMapping("/{sessionId}/submit")
    public List<RestaurantSubmission> submitRestaurant(@PathVariable Long sessionId, @RequestBody String restaurantName) {
         restaurantSubmissionService.submitRestaurant(sessionId, restaurantName);
        return restaurantSubmissionService.getSubmissionsBySession(sessionId);

    }

    @CrossOrigin
    @GetMapping("/{sessionId}/picked")
    public String pickRestaurant(@PathVariable Long sessionId) {
        // Implement the logic to randomly pick a restaurant from the submissions
        List<RestaurantSubmission> submissions = restaurantSubmissionService.getSubmissionsBySession(sessionId);
        Random random = new Random();
        int index = random.nextInt(submissions.size());
        return submissions.get(index).getRestaurantName();
    }

}