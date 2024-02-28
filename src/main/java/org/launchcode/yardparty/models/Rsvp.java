package org.launchcode.yardparty.models;

import java.util.Objects;


public class Rsvp {


    private  int id;

    private static int nextId = 1;

    private String firstName;

    private String lastName;

    private boolean attendance;

    public Rsvp(String firstName, String lastName, boolean attendance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.attendance = attendance;
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
        return id == rsvp.id && attendance == rsvp.attendance && Objects.equals(firstName, rsvp.firstName) && Objects.equals(lastName, rsvp.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, attendance);
    }

    @Override
    public String toString() {
        return "Rsvp{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", attendance=" + attendance +
                '}';
    }
}
