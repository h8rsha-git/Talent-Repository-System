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
@SequenceGenerator(name="seq_genf", sequenceName = "seq_genf", initialValue = 501, allocationSize = 1)
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_genf")
    @Column(name = "feedback_id")
    private long id;
    private String status;
    private int rating;
    private String comment;

    @OneToOne()
    @JoinColumn(name = "fk_interview_id")
    private Interview interview;
}
