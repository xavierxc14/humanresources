package org.tse.humanresources.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.humanresources.model.JobPrivilege;

public interface JobPrivilegeRepository extends JpaRepository<JobPrivilege, Long> {

    JobPrivilege findByJobJobIdAndPrivilegeName(String jobId, String privilegeName);
}