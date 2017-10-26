package org.tse.humanresources.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.humanresources.model.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByFirstName(String firstName);
}