package org.launchcode.yardparty.models.dto;

public class RegistrationFormDTO extends LoginFormDTO{
    private String verifyPassword;

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
}
