package org.tse.humanresources.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.tse.humanresources.model.Job;

import java.math.BigDecimal;
import java.util.List;

@RestResource(exported = false)
public interface JobRepository extends CrudRepository<Job, String> {

    List<Job> findByMinSalaryGreaterThanOrderByMaxSalaryDesc(BigDecimal minSalary);
}