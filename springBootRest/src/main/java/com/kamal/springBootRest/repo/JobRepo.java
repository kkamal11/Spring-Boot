package com.kamal.springBootRest.repo;

import com.kamal.springBootRest.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {

    List<JobPost> jobs = new ArrayList<>();

    public JobRepo() {
        jobs.add(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));

        jobs.add(
                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
                        3, List.of("HTML", "CSS", "JavaScript", "React")));

        jobs.add(new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                List.of("Python", "Machine Learning", "Data Analysis")));

        jobs.add(new JobPost(4, "Network Engineer",
                "Design and implement computer networks for efficient data communication", 5,
                List.of("Networking", "Cisco", "Routing", "Switching")));

        jobs.add(new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android",
                        3, List.of("iOS Development", "Android Development", "Mobile App")));
    }
    public List<JobPost> getAllJobs(){
        return jobs;
    }

    public void addJob(JobPost job){
        jobs.add(job);
    }

    public JobPost getJob(int jobId) {
        JobPost resultantJob = null;
        for(JobPost j : jobs){
            if(j.getPostId() == jobId){
                resultantJob = j;
            }
        }
        return resultantJob;
    }

    public void updateJob(JobPost jobPost) {
        for(JobPost j : jobs){
            if(j.getPostId() == jobPost.getPostId()){
                j.setPostProfile(jobPost.getPostProfile());
                j.setPostDesc(jobPost.getPostDesc());
                j.setReqExperience(jobPost.getReqExperience());
                j.setPostTechStack(jobPost.getPostTechStack());
            }
        }
    }

    public void deleteJob(int id) {
        for(JobPost j : jobs){
            if(j.getPostId() == id){
                jobs.remove(j);
                break;
            }
        }
    }
}
