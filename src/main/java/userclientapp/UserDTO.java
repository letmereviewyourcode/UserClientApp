package userclientapp;

import com.fasterxml.jackson.annotation.JsonProperty; // This line is necessary

public class UserDTO {
    private int id;
    private String email;

    @JsonProperty("first_name") // Map the JSON property to this field
    private String firstName;

    @JsonProperty("last_name") // Map the JSON property to this field
    private String lastName;

    // Getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
