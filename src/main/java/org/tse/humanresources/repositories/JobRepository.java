package org.tse.humanresources.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.humanresources.model.Job;

import java.math.BigDecimal;
import java.util.List;

public interface JobRepository extends JpaRepository<Job, String> {

    List<Job> findByMinSalaryGreaterThanOrderByMaxSalaryDesc(BigDecimal minSalary);
}