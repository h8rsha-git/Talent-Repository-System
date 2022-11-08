package com.tutorial.springbootjpa.controller;
import com.tutorial.springbootjpa.model.Candidate;
import com.tutorial.springbootjpa.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin()
@RestController
public class CandidateController {

    @Autowired
    CandidateRepository candidateRepository;

    // Getting all employees
    @GetMapping("/candidates")
    public ResponseEntity<List<Candidate>> getCandidates() {
        try {
            return new ResponseEntity<>(candidateRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get Employee by id
    @GetMapping("/candidate/{id}")
    public ResponseEntity<Candidate> getEmployeeById(@PathVariable("id") long id) {
        try {
            //check if employee exist in database
            Candidate candidateObj = getCandidateRec(id);
            if (candidateObj != null) {
                return new ResponseEntity<>(candidateObj, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // Create new Employee
    @PostMapping("/candidate")
    public ResponseEntity<Candidate> newCandidate(@RequestBody Candidate candidate) {
        Candidate newCandidate = candidateRepository
                .save(Candidate.builder()
                        .name(candidate.getName())
                        .password(candidate.getPassword())
                        .email(candidate.getEmail())
                        .contact(candidate.getContact())
                        .resume(candidate.getResume())
                        .build());
        return new ResponseEntity<>(newCandidate, HttpStatus.OK);
    }

    // Method to get the candidate record by id
    private Candidate getCandidateRec(long id) {
        Optional<Candidate> candidateObj = candidateRepository.findById(id);

        if (candidateObj.isPresent()) {
            return candidateObj.get();
        }
        return null;
    }

}