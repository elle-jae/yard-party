package org.launchcode.yardparty.controllers;

import org.launchcode.yardparty.data.RsvpData;
import org.launchcode.yardparty.models.Rsvp;
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

    private static List<Rsvp> rsvps = new ArrayList<>();

    @GetMapping("admin-list")
    public String displayNames(Model model) {
        model.addAttribute("rsvps", RsvpData.getAll());
        return "admin/admin";
    }

    @GetMapping("thank-you")
    public String displayThankYou(Model model) {
        model.addAttribute("rsvps", RsvpData.getAll());
        return "rsvp/thank-you";
    }

    @GetMapping("")
    public String showForm(Model model) {
        return "rsvp/form";
    }

    @PostMapping
    public String processForm(@RequestParam String firstName, @RequestParam String lastName, @RequestParam(required = false) boolean attendance){
          RsvpData.add(new Rsvp(firstName, lastName, attendance));
        return "redirect:rsvp/thank-you";
    }
}

