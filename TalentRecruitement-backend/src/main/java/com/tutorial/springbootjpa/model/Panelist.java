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
@SequenceGenerator(name="seq_genp", sequenceName = "seq_genp", initialValue = 201, allocationSize = 1)
public class Panelist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_genp")
    @Column(name = "panelist_id")
    private long panelistId;
    private String name;
    private String password;
    private String designation;
    private String emailId;
}
