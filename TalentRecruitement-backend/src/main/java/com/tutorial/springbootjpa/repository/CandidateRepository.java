package com.tutorial.springbootjpa.repository;

import com.tutorial.springbootjpa.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}