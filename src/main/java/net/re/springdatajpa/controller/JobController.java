package net.re.springdatajpa.controller;

import net.re.springdatajpa.helper.NotFoundException;
import net.re.springdatajpa.model.Job;
import net.re.springdatajpa.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600, origins = {"http://localhost:3015"})
public class JobController {
    @Autowired
    JobRepository jobRepository;

    @GetMapping("/jobs")
    @ResponseBody
    public List<Job> findAll(@RequestParam(required = false) String s) throws Exception {
        if (s != null && s.equals("a")) {
            throw new Exception("Something went wrong");
        }
        if(s == null || s.isEmpty()) return jobRepository.findAll();
        return jobRepository.findByKeyword(s);
    }

    @GetMapping("/jobs/{jobId}")
    @ResponseBody
    public Job findOne(@PathVariable("jobId") int jobId){
        Optional<Job> job = jobRepository.findById(jobId);
        return job.orElseThrow(() -> new NotFoundException(String.format("Job[id=%s] not found!", job)));
    }

    @PostMapping("/jobs")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Job create(@RequestBody Job job){
        return jobRepository.save(job);
    }

    @PutMapping("/jobs/{jobId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Job update(@PathVariable("jobId") int jobId, @RequestBody Job job){
        // call log
        // call sec
        // validation
        // exception
        job.setId(jobId);
        return jobRepository.save(job);
    }

    @DeleteMapping("/jobs/{jobId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void deleteJob(@PathVariable("jobId") int jobId){
       jobRepository.deleteById(jobId);
    }
}
