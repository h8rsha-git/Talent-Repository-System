package com.tutorial.springbootjpa.controller;
import com.tutorial.springbootjpa.model.Candidate;
import com.tutorial.springbootjpa.model.Feedback;
import com.tutorial.springbootjpa.model.Interview;
import com.tutorial.springbootjpa.repository.CandidateRepository;
import com.tutorial.springbootjpa.repository.FeedbackRepository;
import com.tutorial.springbootjpa.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin()
@RestController
public class InterviewController {

    @Autowired
    InterviewRepository interviewRepository;

    // Getting all interviews
    @GetMapping("/interviews")
    public ResponseEntity<List<Interview>> getInterviews() {
        try {
            return new ResponseEntity<>(interviewRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/interview/{id}")
    public ResponseEntity<Interview> getInterviewById(@PathVariable("id") long id) {
        try {
            //check if employee exist in database
            Interview interviewObj = getInterviewRec(id);
            if (interviewObj != null) {
                return new ResponseEntity<>(interviewObj, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Interview getInterviewRec(long id) {
        Optional<Interview> interviewObj = interviewRepository.findById(id);

        if (interviewObj.isPresent()) {
            return interviewObj.get();
        }
        return null;
    }

    // Create new Interview
    @PostMapping("/interview")
    public ResponseEntity<Interview> newInterview(@RequestBody Interview interview) {
        Interview newInterview = interviewRepository
                        .save(Interview.builder()
                        .candidateId(interview.getCandidateId())
                        .panelistId(interview.getPanelistId())
                                .level(interview.getLevel())
                                .title(interview.getTitle())
                                .build());
        return new ResponseEntity<>(newInterview, HttpStatus.OK);
    }

}