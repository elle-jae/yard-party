package org.launchcode.yardparty.controllers;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("rsvp")
public class FormController {

    private static List<String> firstNames = new ArrayList<>();

    @GetMapping("admin-list")
    public String displayFirstNames(Model model) {
        model.addAttribute("lastName", "Smith");
        model.addAttribute("fristName", firstNames);
        return "admin/admin";
    }

    @GetMapping("thank-you")
    public String displayThankYou(Model model) {
        model.addAttribute("lastName", "Smith");
        model.addAttribute("name", firstNames);
        return "rsvp/thank-you";
    }

    @GetMapping("")
    public String showForm(Model model) {
        return "rsvp/form";
    }

    @PostMapping
    public String processForm(@RequestParam String name){
       firstNames.add(name);
        return "redirect:rsvp/thank-you";
    }
}

