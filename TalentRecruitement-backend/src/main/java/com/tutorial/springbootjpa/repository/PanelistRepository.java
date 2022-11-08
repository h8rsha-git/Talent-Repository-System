package com.tutorial.springbootjpa.repository;

import com.tutorial.springbootjpa.model.Panelist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanelistRepository extends JpaRepository<Panelist, Long> {
}
