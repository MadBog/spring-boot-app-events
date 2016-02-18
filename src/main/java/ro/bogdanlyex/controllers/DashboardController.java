package ro.bogdanlyex.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class DashboardController {

    @RequestMapping(value = {"/", "/dashboard"})
    public String index() {
        return "dashboard";
    }
}
