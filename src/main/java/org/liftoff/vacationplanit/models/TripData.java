package org.liftoff.vacationplanit.models;

import java.util.ArrayList;

public class TripData {

    static ArrayList<Trip> trips = new ArrayList<>();

    // getAll
    public static ArrayList<Trip> getAll() {
        return trips;
    }

    // add
    public static void add(Trip newTrip) {
        trips.add(newTrip);
    }


    // remove
    public static void remove(int id) {
        Trip tripToRemove = getById(id);
        trips.remove(tripToRemove);
    }


    // getById
    public static Trip getById(int id) {

        Trip theTrip = null;

        for (Trip candidateTrip : trips) {
            if (candidateTrip.getTripId() == id) {
                theTrip = candidateTrip;
            }
        }

        return theTrip;
    }

}
