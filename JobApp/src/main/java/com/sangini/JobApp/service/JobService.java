package com.sangini.JobApp.service;

import com.sangini.JobApp.model.JobPost;
import com.sangini.JobApp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepo jobRepo;
    public void addJob(JobPost jobPost){
        jobRepo.addJob(jobPost);
    }
    public List<JobPost> getAllJobs(){
        return jobRepo.getAllJobs();
    }
}
