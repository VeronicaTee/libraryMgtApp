package com.veronica;

/**
 * This is the class of all Library users.
 * The Librarian and Patrons classes are child classes of this class
 */
public class User {
    private String firstName, lastName;

    /**
     * Creates a user
     * @param firstName  The user's first name.
     * @param lastName The user's last name.
     */
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    // Getters and Setters
    /**
     *
     * @return The user's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName The user's first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return The user's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName The user's last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
