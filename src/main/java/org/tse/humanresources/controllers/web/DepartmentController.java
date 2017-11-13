package org.tse.humanresources.controllers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tse.humanresources.model.Department;
import org.tse.humanresources.model.Location;
import org.tse.humanresources.repositories.DepartmentRepository;
import org.tse.humanresources.repositories.LocationRepository;

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping
    public String list(Model model) {
        List<Department> departments = departmentRepository.findAll();
        model.addAttribute("departments", departments);
        return "departments/list";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Department department = departmentRepository.findOne(id);
        List<Location> locations = locationRepository.findAll();
        model.addAttribute("department", department);
        model.addAttribute("locations", locations);
        return "departments/form";
    }

    @PostMapping("save")
    public String save(Department department) {
        departmentRepository.save(department);
        return "redirect:/departments";
    }

}
