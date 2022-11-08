package com.tutorial.springbootjpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@SequenceGenerator(name="seq_genc", sequenceName = "seq_genc", initialValue = 101, allocationSize = 50)
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_genc")
    @Column(name = "candidate_id")
    private Long candidateId;
    private String name;
    private String password;
    private String email;
    private Long contact;
    private String resume;
}
