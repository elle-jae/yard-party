package org.launchcode.yardparty.models;

import java.util.Objects;

public class Rsvp {


    private  int id;

    private static int nextId = 1;

    private String name;


    public Rsvp(String name) {
        this.id = nextId;
        nextId++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rsvp rsvp = (Rsvp) o;
        return id == rsvp.id && Objects.equals(name, rsvp.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Rsvp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
