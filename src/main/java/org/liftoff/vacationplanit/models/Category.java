package org.liftoff.vacationplanit.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category extends AbstractEntity {

    @NotNull
    @Size(min=3, max=100)
    private String name;

    @OneToMany
    @JoinColumn(name = "category_uid")
    private List<Trip> trips = new ArrayList<>();

    public Category() {}

    public Category(String name) {this.name = name; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Trip> getTrips() { return trips; }

}
