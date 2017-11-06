package org.tse.humanresources.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.tse.humanresources.model.Job;
import org.tse.humanresources.repositories.JobRepository;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(path = "/api/job",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @PatchMapping("/update/{id}")
    public Job updateIdAndName(@PathVariable String id, @RequestBody Job job) {
        Job updatedJob = jobRepository.findOne(id);
        updatedJob.setJobTitle(job.getJobTitle());
        return jobRepository.saveAndFlush(updatedJob);
    }

    @PostMapping("/greater-salary")
    public List<Job> allWithSalaryGreaterThanOrderedByMaxSalaryDesc(@RequestBody BigDecimal minSalary) {
        return jobRepository.findByMinSalaryGreaterThanOrderByMaxSalaryDesc(minSalary);
    }

}
