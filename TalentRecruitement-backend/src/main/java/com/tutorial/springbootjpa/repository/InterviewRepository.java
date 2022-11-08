package com.tutorial.springbootjpa.repository;

import com.tutorial.springbootjpa.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Interview, Long> {
}
