package org.launchcode.yardparty.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//TO DO: Check with Sammie about extending Abstract Enity-look a realtionships chapter

@Entity
public class AdminUser {

//    TO DO: check this was okay to pull over to be similar to Rsvp model class since I currently don't have an abstract entity class'
    @Id
    @GeneratedValue
    private  int id;
    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AdminUser() {}

    public AdminUser(String username, String password) {
        this.id = id;
        this.username = username;
        this.pwHash encoder.encode(password);
    }


    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

}
