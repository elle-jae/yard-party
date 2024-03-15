package org.launchcode.yardparty.controllers;

import jakarta.servlet.http.HttpSession;
import org.launchcode.yardparty.data.AdminUserRepository;
import org.launchcode.yardparty.models.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
}
