package com.swe.challenge.mealkakis.event;


import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
public class SessionJoinEvent {

    private Long sessionID;
    private Set<String> participant;
    private String newParticipant;

    public SessionJoinEvent(Long sessionID, Set<String> participant, String newParticipant) {
        this.sessionID = sessionID;
        this.participant = participant;
        this.newParticipant = newParticipant;
    }


}