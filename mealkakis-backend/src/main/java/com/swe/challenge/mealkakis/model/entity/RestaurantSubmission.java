package com.swe.challenge.mealkakis.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RestaurantSubmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String restaurantName;

    private boolean finalResult;
    // Other submission properties

    // Relationships
    @ManyToOne
    @JsonIgnore
    private Session session;

    public RestaurantSubmission(String pickedRestaurant) {
        this.restaurantName = pickedRestaurant;
        this.finalResult = true;
    }

    // Constructors, getters, and setters
}

