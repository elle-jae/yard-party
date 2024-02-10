package org.launchcode.yardparty.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FormController {

    @GetMapping("/rsvp-form")
    @ResponseBody
    public String getFormPageContent() {
        return "RSVP Form";
    }

}

