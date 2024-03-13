package org.launchcode.yardparty.controllers;

import org.launchcode.yardparty.data.RsvpData;
import org.launchcode.yardparty.data.RsvpRepository;
import org.launchcode.yardparty.models.Rsvp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private RsvpRepository rsvpRepository;

//    private static List<Rsvp> rsvps = new ArrayList<>();

    @GetMapping("")
    public String getAdminPageContent() {
        return "admin/index";
    }

    @GetMapping("/rsvp-list")
    public String displayRsvps(Model model) {
        model.addAttribute("rsvps", rsvpRepository.findAll());
        return "admin/admin-list";
    }

    @GetMapping("/delete")
    public String showDeleteRsvpForm(Model model) {
        model.addAttribute("title", "Delete RSVP");
        model.addAttribute("rsvps", rsvpRepository.findAll());
        return "admin/delete";
    }

    @PostMapping("delete")
    public String processDeleteRsvpForm(@RequestParam(required = false) int[] rsvpIds) {
       for(int id : rsvpIds) {
          rsvpRepository.deleteById(id);
       }
       return "redirect:/admin/rsvp-list";
    }
}
