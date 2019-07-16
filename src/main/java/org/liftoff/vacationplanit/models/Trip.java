package org.liftoff.vacationplanit.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Trip {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=100)
    private String name;

    @NotNull
    @Size(min=1, message = "Trip Description must not be empty.")
    private String description;

    private TripType type;

    public Trip(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Trip() { }

    public int getId() { return id; }

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

    public TripType getType() { return type; }

    public void setType(TripType type) { this.type = type; }
}
