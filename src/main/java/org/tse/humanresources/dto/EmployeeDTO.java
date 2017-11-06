package org.tse.humanresources.dto;

import lombok.Data;
import org.tse.humanresources.model.Department;

@Data
public class EmployeeDTO {

    private String firstName;

    private String lastName;

    private Department department;
}
