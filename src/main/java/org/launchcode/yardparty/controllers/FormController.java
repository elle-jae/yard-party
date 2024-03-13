package org.launchcode.yardparty.controllers;

import jakarta.validation.Valid;
import org.launchcode.yardparty.data.RsvpRepository;
import org.launchcode.yardparty.models.Attendance;
import org.launchcode.yardparty.models.Rsvp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("rsvp")
public class FormController {

    @Autowired
    private RsvpRepository rsvpRepository;
//    private static List<Rsvp> rsvps = new ArrayList<>();

    @GetMapping("admin-list")
    public String displayNames(Model model) {
        model.addAttribute("rsvps", rsvpRepository.findAll());
        return "admin/admin-list";
    }

    @GetMapping("thank-you")
    public String displayThankYou(Model model) {
        model.addAttribute("rsvps", rsvpRepository.findAll());
        return "rsvp/thank-you";
    }

    @GetMapping("")
    public String showForm(Model model) {
        model.addAttribute("title", "RSVP Form");
        model.addAttribute("rsvp", new Rsvp());
        model.addAttribute("status", Attendance.values());
        return "rsvp/form";
    }

    @PostMapping
    public String processForm(@ModelAttribute @Valid Rsvp newRsvp, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "RSVP Form");
            model.addAttribute("errorMsg", "Missing required fields");
            return "rsvp/form";
        }
        rsvpRepository.save(newRsvp);
        return "redirect:rsvp/thank-you";
    }

//    @PostMapping
//    public String processForm(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam(required = false) boolean attendance){
//          RsvpData.add(new Rsvp(firstName, lastName, email, attendance));
//        return "redirect:rsvp/thank-you";
//    }
}

