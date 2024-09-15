package com.sangini.SpringBootRest.controller;

import com.sangini.SpringBootRest.model.JobPost;
import com.sangini.SpringBootRest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    JobService jobService;

    @PostMapping("jobPost")
    public void addJob(JobPost jobPost) {
        jobService.addJob(jobPost);
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable int postId) {

        return jobService.getJobWithId(postId);
    }

    @PutMapping("jobPost")
    public void updateJob(@RequestBody JobPost jobPost) {
        jobService.updateJob(jobPost);
    }

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs() {
        return jobService.getAllJobs();

    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> search(@PathVariable("keyword")  String keyword) {
        return jobService.findByKeyword(keyword);

    }

    @DeleteMapping("jobPost/{postId}")
    public void deleteJob(@PathVariable int postId) {
        jobService.deleteJob(postId);

    }

    @GetMapping("load")
    public void loadPosts() {
        jobService.load();

    }

}
