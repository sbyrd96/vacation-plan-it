package org.liftoff.vacationplanit.models.forms;

import org.liftoff.vacationplanit.models.User;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginForm {

    @NotNull
    @Size(min=5, max= 20)
    //@Pattern(regexp = "[a-zA-Z][a-zA-Z0-9_-]{4,11}", message = "Please try again. Username must be between 4-11 characters (letters and numbers only).")
    private String username;

    @NotNull
    @Size(min=5, max= 20, message = "Password must be at least 5 characters long.")
    //@Pattern(regexp = "(\\S){4,20}", message = "Please try again. Passwords must be between 4-20 characters.")
    private String password;

    //public User(String username, String email, String password) {
    //    this.username = username;
    //    this.password = password;
    //}



    public LoginForm() {}

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

}
