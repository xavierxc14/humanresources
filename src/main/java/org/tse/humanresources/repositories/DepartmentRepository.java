package org.tse.humanresources.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.humanresources.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}