package com.swe.challenge.mealkakis.service;

import com.swe.challenge.mealkakis.model.entity.Session;
import com.swe.challenge.mealkakis.repository.jpa.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Session createSession() {
        Session session = new Session();
        session.setActive(true);
        // Set session properties
        return sessionRepository.save(session);
    }

    public Session endSession(Long sessionId,String pickedRestaurant) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid session ID"));
        session.setActive(false);
        session.setPickedRestaurant(pickedRestaurant);
        // Perform wheel spin logic here
        return sessionRepository.save(session);
    }

    // Other session management methods
}