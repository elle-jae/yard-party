package org.launchcode.yardparty.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.launchcode.yardparty.data.AdminUserRepository;
import org.launchcode.yardparty.models.AdminUser;
import org.launchcode.yardparty.models.dto.LoginFormDTO;
import org.launchcode.yardparty.models.dto.RegistrationFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AuthenticationController {

    @Autowired
    AdminUserRepository adminUserRepository;

    private static final String adminUserSessionKey = "adminUser";

    public AdminUser getUserFromSession(HttpSession session) {
        Integer adminUserId = (Integer) session.getAttribute(adminUserSessionKey);
        if (adminUserId == null) {
            return null;
        }

        Optional<AdminUser> adminUser = adminUserRepository.findById(adminUserId);

        if (adminUser.isEmpty()) {
            return null;
        }

        return adminUser.get();
    }
//TO DO: Does this need to be updated if an Absract Entity is created?
    private static void setUserInSession(HttpSession session, AdminUser adminUser) {
        session.setAttribute(adminUserSessionKey, adminUser.getId());
    }

    @GetMapping("/register")
    public String displayRegistrationForm(Model model) {
        model.addAttribute(new RegistrationFormDTO());
        model.addAttribute("title", "Register");
        return "register";
    }

    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute @Valid RegistrationFormDTO registrationFormDTO,
                                          Errors errors, HttpServletRequest request,
                                          Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Register");
            model.addAttribute("errorMsg", "Missing required fields");
            return "register";
        }

        AdminUser existingUser = adminUserRepository.findByUsername(registrationFormDTO.getUsername());

        if (existingUser != null) {
            errors.rejectValue("username", "username.alreadyexists", "A user with that username already exists");
            model.addAttribute("title", "Register");
            return "register";
        }

        String password = registrationFormDTO.getPassword();
        String verifyPassword = registrationFormDTO.getVerifyPassword();
        if (!password.equals(verifyPassword)) {
            errors.rejectValue("password", "passwords.mismatch", "Passwords do not match");
            model.addAttribute("title", "Register");
            return "register";
        }

        AdminUser newUser = new AdminUser(registrationFormDTO.getUsername(), registrationFormDTO.getPassword());
        adminUserRepository.save(newUser);
        setUserInSession(request.getSession(), newUser);

        return "redirect:";
    }

    @GetMapping("/login")
    public String displayLoginForm(Model model) {
        model.addAttribute(new LoginFormDTO());
        model.addAttribute("title", "Log In");
        return "login";
    }
    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO,
                                   Errors errors, HttpServletRequest request,
                                   Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Log In");
            model.addAttribute("errorMsg", "Missing required fields");
            return "login";
        }

        AdminUser theUser = adminUserRepository.findByUsername(loginFormDTO.getUsername());

        if (theUser == null) {
            errors.rejectValue("username", "user.invalid", "The given username does not exist");
            model.addAttribute("title", "Log In");
            return "login";
        }

        String password = loginFormDTO.getPassword();

        if (!theUser.isMatchingPassword(password)) {
            errors.rejectValue("password", "password.invalid", "Invalid password");
            model.addAttribute("title", "Log In");
            return "login";
        }

        setUserInSession(request.getSession(), theUser);

        return "redirect:/admin/rsvp-list";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/login";
    }
}
