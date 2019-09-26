package org.liftoff.vacationplanit.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Trip extends AbstractEntity{

    @ManyToOne
    private User owner;

    @NotNull
    @Size(min=3, max=100)
    private String name;

    @NotNull
    @Size(min=1, message = "Trip Description must not be empty.")
    private String description;

    @ManyToOne
    private Category category;

    @ManyToMany(mappedBy = "trips")
    private List <Plan> plans;

    public Trip(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Trip() { }

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

    public Category getCategory() { return category; }

    public void setCategory(Category category) { this.category = category; }

    public User getOwner() { return owner; }

    public void setOwner(User owner) { this.owner = owner; }
}
