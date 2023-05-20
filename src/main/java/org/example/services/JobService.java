package org.example.services;

import org.example.entities.Employee;
import org.example.entities.Job;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobService {
    Job saveJob(Job job);

    Job updateJob(Job job);

    Job getJob(Long id);

    List<Job> getAllJobs();

    void deleteJobById(Long id);

    void deleteAllJobs();

    Page<Job> getAllJobsByPage(int page, int size);


}
