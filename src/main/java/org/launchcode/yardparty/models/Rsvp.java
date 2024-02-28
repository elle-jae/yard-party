package org.launchcode.yardparty.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;


public class Rsvp {


    private  int id;

    private static int nextId = 1;

    @NotBlank (message = "First Name is required")
    @Size(min = 1, max = 15)
    private String firstName;

    @NotBlank (message = "Last Name is required")
    @Size(min = 1, max = 25)
    private String lastName;

    @NotBlank (message = "Email is required")
    @Email
    private String email;

    private boolean attendance;

    public Rsvp(String firstName, String lastName, String email, boolean attendance) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.attendance = attendance;
    }

    public Rsvp() {
        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAttendance() {
        return attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rsvp rsvp = (Rsvp) o;
        return id == rsvp.id && attendance == rsvp.attendance && Objects.equals(firstName, rsvp.firstName) && Objects.equals(lastName, rsvp.lastName) && Objects.equals(email, rsvp.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, attendance);
    }

    @Override
    public String toString() {
        return "Rsvp{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", attendance=" + attendance +
                '}';
    }
}
