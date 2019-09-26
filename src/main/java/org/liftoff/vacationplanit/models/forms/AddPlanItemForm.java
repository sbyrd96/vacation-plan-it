package org.liftoff.vacationplanit.models.forms;

import org.liftoff.vacationplanit.models.Plan;
import org.liftoff.vacationplanit.models.Trip;

import javax.validation.constraints.NotNull;
import java.util.List;

public class AddPlanItemForm {

    @NotNull
    private int planId;

    @NotNull
    private int tripId;

    private Iterable<Trip> trips;

    private Plan plan;

    public AddPlanItemForm() {}

    public AddPlanItemForm(Iterable<Trip> trips, Plan plan) {
        this.trips = trips;
        this.plan = plan;
    }

    public int getPlanId() { return planId; }

    public void setPlanId(int planId) { this.planId = planId; }

    public int getTripId() { return tripId; }

    public void setTripId(int tripId) { this.tripId = tripId; }

    public Iterable<Trip> getTrips() { return trips; }

    public Plan getPlan() { return plan; }

}
