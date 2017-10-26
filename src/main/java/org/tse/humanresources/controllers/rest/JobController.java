package org.tse.humanresources.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tse.humanresources.model.Job;
import org.tse.humanresources.repositories.JobRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/job", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Job> updateIdAndName(@PathVariable String id, @RequestBody Map<String, String> job) {
        Job updatedJob = jobRepository.findOne(id);
        updatedJob.setJobId(job.get("jobId"));
        updatedJob.setJobTitle(job.get("jobTitle"));
        updatedJob = jobRepository.save(updatedJob);
        return new ResponseEntity<>(updatedJob, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/greater-salary", method = RequestMethod.GET)
    public List<Job> allWithSalaryGreaterThanOrderedByMaxSalaryDesc(@RequestBody BigDecimal minSalary) {
        return jobRepository.findByMinSalaryGreaterThanOrderByMaxSalaryDesc(minSalary);
    }

}
