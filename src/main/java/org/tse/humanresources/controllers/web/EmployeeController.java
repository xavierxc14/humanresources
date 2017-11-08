package org.tse.humanresources.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping("salaries")
    public String index() {
        return "employees/salaries";
    }

}
