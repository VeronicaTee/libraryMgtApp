package com.veronica;

import lombok.Getter;
import lombok.Setter;

/**
 * This handles the basic information of patrons who have borrowed books and are added to the lenders log to track them
 */

@Getter
@Setter
public class Borrower {
    private String firstName;
    private String lastName;
    private String bookName;

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

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
