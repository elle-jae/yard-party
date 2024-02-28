package org.launchcode.yardparty.data;

import org.launchcode.yardparty.models.Rsvp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RsvpData {
    private static Map<Integer, Rsvp> rsvps = new HashMap<>();

    public static Collection<Rsvp> getAll() {
        return rsvps.values();
    }

    public static void add(Rsvp rsvp) {
        rsvps.put(rsvp.getId(), rsvp);
    }

    public static Rsvp getById(Integer id) {
        return rsvps.get(id);
    }

    public static void remove(Integer id) {
        if (rsvps.containsKey(id)) {
            rsvps.remove(id);
        }
    }
}
