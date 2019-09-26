package org.liftoff.vacationplanit.models;

//import org.springframework.security

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User extends AbstractEntity {

    @NotNull
    //@Pattern(regexp = "[a-zA-Z][a-zA-Z0-9_-]{5,20}", message = "Invalid username")
    @Size(min=5, max= 20)
    private String username;

    @NotNull
    @Size(min= 5, max= 20, message = "Passwords must be at least 5 characters long.")
    //private String password;
     String pwHash;
    //private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @OneToMany
    @JoinColumn(name = "owner_uid")
    private List<Trip> trips;

    public User() {}

    public User(String username, String password) {
        this.username = username;
    //    this.password = password;
    //    this.pwHash = hashPassword(password);
    }

    public String getUsername() { return username; }

    //public void setUsername(String username) { this.username = username; }

    //public String getPassword() { return password; }

    //public void setPassword(String password) { this.password = password; }

    //private static String hashPassword(String password) {
    //    return encoder.encode(password);
    //}

    //public boolean isMatchingPassword(String password) {
    //    return encoder.matches(password, pwHash);
    //}

    protected void addTrip(Trip trip) { trips.add(trip); }

    public List<Trip> getTrips() { return trips; }

}
