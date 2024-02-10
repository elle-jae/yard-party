package org.launchcode.yardparty.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class YouAreInvitedController {

    @GetMapping("/")
    @ResponseBody

    public String getYouAreInvitedPageContent() {
        return "You are invited!";
    }
}
