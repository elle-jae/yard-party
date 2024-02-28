package org.launchcode.yardparty.models;

public enum Attendance {
    YES("Yes, can't wait!"),
    NO("No, can't make it");
    private final String displayName;

    Attendance(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
