package org.example.services;

import org.example.entities.Employee;
import org.example.entities.Job;
import org.example.respository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobRepository jobRepository;
    @Override
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job updateJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job getJob(Long id) {
        return jobRepository.findById(id).get();
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public void deleteJobById(Long id) {
        jobRepository.deleteById(id);
    }

    @Override
    public void deleteAllJobs() {
        jobRepository.deleteAll();
    }

    public Page<Job> getAllJobsByPage(int page, int size) {
        return jobRepository.findAll(PageRequest.of(page,size));
    }
}
