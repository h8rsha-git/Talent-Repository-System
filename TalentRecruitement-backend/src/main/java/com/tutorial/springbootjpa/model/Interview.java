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
@SequenceGenerator(name="seq_geni", sequenceName = "seq_geni", initialValue = 301, allocationSize = 1)
public class Interview{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_geni")
    @Column(name = "interview_id")
    private long id;
    @Column(name = "candidate_id")
    private long candidateId;
    @Column(name = "panelist_id")
    private long panelistId;
    private String title;
    private int level;
}
