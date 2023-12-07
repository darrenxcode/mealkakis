package com.swe.challenge.mealkakis.repository.jpa;

import com.swe.challenge.mealkakis.model.entity.RestaurantSubmission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantSubmissionRepository extends JpaRepository<RestaurantSubmission, Long> {

}
