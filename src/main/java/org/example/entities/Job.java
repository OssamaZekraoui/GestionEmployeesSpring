package org.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJob;
    @NotNull
    private String title;
    @NotNull
    @Size(min = 3, max = 255)
    private String description;
    @DecimalMin(value = "0.0")
    private double salary;
    @OneToMany(mappedBy = "job")
    private List<Employee> employees;


}
