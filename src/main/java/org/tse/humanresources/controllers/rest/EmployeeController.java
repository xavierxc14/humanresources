package org.tse.humanresources.controllers.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tse.humanresources.dto.EmployeeDTO;
import org.tse.humanresources.model.Employee;
import org.tse.humanresources.repositories.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController("employeeRestController")
@RequestMapping("/api/custom/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("first-name")
    public List<EmployeeDTO> allWithFirstName(@RequestBody Employee employee) {
        List<Employee> employees = employeeRepository.findByFirstName(employee.getFirstName());
        System.out.println(employees.size());
        ModelMapper modelMapper = new ModelMapper();
        return employees.stream()
                .map(e -> modelMapper.map(e, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

}
