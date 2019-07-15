package org.liftoff.vacationplanit.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Trip {

    @NotNull
    @Size(min=3, max=100)
    private String name;

    @NotNull
    @Size(min=1, message = "Trip Description must not be empty.")
    private String description;

    private int tripId;
    private static int nextId = 1;

    public Trip(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public Trip() {
        tripId = nextId;
        nextId++;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
