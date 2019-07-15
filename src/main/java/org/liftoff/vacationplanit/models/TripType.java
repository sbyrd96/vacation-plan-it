package org.liftoff.vacationplanit.models;

public enum TripType {

    FAMILY ("Family Trip"),
    BUSINESS ("Business Trip"),
    CONFERENCE ("Conference/Personal Development");

    private final String name;

    TripType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
