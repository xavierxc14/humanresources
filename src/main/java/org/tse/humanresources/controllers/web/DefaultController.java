package org.tse.humanresources.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DefaultController {

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("login")
    public String login() {
        return "/login";
    }

    @GetMapping("403")
    public String error403() {
        return "/error/403";
    }

    @GetMapping("404")
    public String error404() {
        return "/error/404";
    }

}
