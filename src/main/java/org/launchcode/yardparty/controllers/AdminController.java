package org.launchcode.yardparty.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private static List<String> firstNames = new ArrayList<>();

    @GetMapping("")
    public String getAdminPageContent() {
        return "admin/index";
    }

    @GetMapping("/rsvp-list")
    public String displayFirstNames(Model model) {
        model.addAttribute("lastName", "Smith");
        model.addAttribute("name", firstNames);
        return "admin/admin";
    }
}
