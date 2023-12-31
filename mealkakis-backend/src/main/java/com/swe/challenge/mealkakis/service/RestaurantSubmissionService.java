package com.swe.challenge.mealkakis.service;

import com.swe.challenge.mealkakis.model.entity.RestaurantSubmission;
import com.swe.challenge.mealkakis.model.entity.Session;
import com.swe.challenge.mealkakis.repository.jpa.RestaurantSubmissionRepository;
import com.swe.challenge.mealkakis.repository.jpa.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantSubmissionService {

    private final SessionRepository sessionRepository;

    private final RestaurantSubmissionRepository restaurantSubmissionRepo;

    @Autowired
    public RestaurantSubmissionService(RestaurantSubmissionRepository restaurantSubmissionRepo,SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;

        this.restaurantSubmissionRepo = restaurantSubmissionRepo;
    }

    public void submitRestaurant(Long sessionId, String restaurantName) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid session ID"));
        RestaurantSubmission submission = new RestaurantSubmission();
        submission.setRestaurantName(restaurantName);
        submission.setSession(session);
        restaurantSubmissionRepo.save(submission);
    }

    public List<RestaurantSubmission> getSubmissionsBySession(Long sessionId) {
        Optional<Session> session = sessionRepository.findById(sessionId);
        if (session.isPresent()) {
           if (session.get().isActive()) {
               return session.get().getRestaurantSubmissions();
           }else {
               List<RestaurantSubmission> finalResult = new ArrayList<>();
               finalResult.add(new RestaurantSubmission(session.get().getPickedRestaurant()));
               return finalResult;
           }
        }
        return null;
    }

}