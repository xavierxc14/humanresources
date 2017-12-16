package org.tse.humanresources.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "jobs")
@NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j")
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "JOB_ID")
    private String jobId;

    @Column(name = "JOB_TITLE")
    private String jobTitle;

    @Column(name = "MAX_SALARY")
    private BigDecimal maxSalary;

    @Column(name = "MIN_SALARY")
    private BigDecimal minSalary;

    @JsonIgnore
    @OneToMany(mappedBy = "job")
    private List<JobPrivilege> jobPrivileges;

    public String getJobId() {
        return this.jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public BigDecimal getMaxSalary() {
        return this.maxSalary;
    }

    public void setMaxSalary(BigDecimal maxSalary) {
        this.maxSalary = maxSalary;
    }

    public BigDecimal getMinSalary() {
        return this.minSalary;
    }

    public void setMinSalary(BigDecimal minSalary) {
        this.minSalary = minSalary;
    }

    public List<JobPrivilege> getJobPrivileges() {
        return jobPrivileges;
    }

    public void setJobPrivileges(List<JobPrivilege> jobPrivileges) {
        this.jobPrivileges = jobPrivileges;
    }
}