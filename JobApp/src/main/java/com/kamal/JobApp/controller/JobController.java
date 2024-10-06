package com.kamal.JobApp.controller;

import com.kamal.JobApp.model.JobPost;
import com.kamal.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService service;

    @RequestMapping({"/","/home"})
    public String home(){
        return "home";
    }

    @RequestMapping("/addjob")
    public String addJob(){
        return "addjob";
    }

    @RequestMapping(value = "handleForm", method = RequestMethod.POST)
    public String handleForm(JobPost jobPost){
        service.addJob(jobPost);
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewAllJobs(Model model){
        List<JobPost> allJobs = service.getAllJobs();
        model.addAttribute("jobPosts",allJobs);
        return "viewalljobs";

    }
}
