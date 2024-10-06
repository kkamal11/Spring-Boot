package com.kamal.springBootRest;

import com.kamal.springBootRest.model.JobPost;
import com.kamal.springBootRest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//@Controller
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping({"/","/home"})
    @ResponseBody
    public String home(){
        return "Request Successful....";
    }

    @GetMapping("/posts")
    @ResponseBody
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("/post/{jobId}")
    @ResponseBody
    public JobPost getJob(@PathVariable("jobId") int jobId){
        return service.getJob(jobId);
    }

    @PostMapping("/post")
    public JobPost addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("/post")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("/post/{jobId}")
    public String deleteJob(@PathVariable("jobId") int id){
        service.deleteJob(id);
        return "Job Id: " + id +" Deleted";
    }
}
