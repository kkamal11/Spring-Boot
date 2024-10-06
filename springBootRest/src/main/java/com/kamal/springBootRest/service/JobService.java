package com.kamal.springBootRest.service;

import com.kamal.springBootRest.model.JobPost;
import com.kamal.springBootRest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost job){
        repo.addJob(job);
    }

    public List<JobPost> getAllJobs(){
        return repo.getAllJobs();
    }

    public JobPost getJob(int jobId){
        return repo.getJob(jobId);
    }

    public void updateJob(JobPost jobPost) {
        repo.updateJob(jobPost);
    }


    public void deleteJob(int id) {
        repo.deleteJob(id);
    }
}
