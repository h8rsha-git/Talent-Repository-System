package com.tutorial.springbootjpa.repository;

import com.tutorial.springbootjpa.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
