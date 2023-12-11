package com.swe.challenge.mealkakis.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean active;
    private String pickedRestaurant;
    // Other session properties

    // Relationships
    @OneToMany(mappedBy = "session")
    private List<RestaurantSubmission> restaurantSubmissions = new ArrayList<>();

}