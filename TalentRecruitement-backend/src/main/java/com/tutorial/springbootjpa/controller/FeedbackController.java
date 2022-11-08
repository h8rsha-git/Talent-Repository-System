package com.tutorial.springbootjpa.controller;

import com.tutorial.springbootjpa.model.Feedback;
import com.tutorial.springbootjpa.model.Interview;
import com.tutorial.springbootjpa.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
public class FeedbackController {

    @Autowired
    FeedbackRepository feedbackRepository;

    @GetMapping("/feedbacks")
    public ResponseEntity<List<Feedback>> getInterviews() {
        try {
            return new ResponseEntity<>(feedbackRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Create new Employee
    @PostMapping("/feedback")
    public ResponseEntity<Feedback> newFeedback(@RequestBody Feedback feedback) {
        Feedback newFeedback = feedbackRepository
                .save(Feedback.builder()
                        .status(feedback.getStatus())
                        .rating(feedback.getRating())
                        .comment(feedback.getComment())
                        .interview(feedback.getInterview())
                        .build());
        return new ResponseEntity<>(newFeedback, HttpStatus.OK);
    }
}
