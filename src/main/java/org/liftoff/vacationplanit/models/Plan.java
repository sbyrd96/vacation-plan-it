package org.liftoff.vacationplanit.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Plan extends AbstractEntity {

    @NotNull
    @Size(min=3, max=50)
    private String name;

    @ManyToMany
    private List<Trip> trips;

    public Plan() {}

    public void addItem(Trip item) { trips.add(item); }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public List<Trip> getTrips() { return trips; }
}
