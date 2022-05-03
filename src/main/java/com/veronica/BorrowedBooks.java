package com.veronica;

import lombok.Getter;
import lombok.Setter;

/**
 * This handles the basic information of books that have been borrowed from the Library in order to track them
 */

@Getter
@Setter
public class BorrowedBooks {
    private String borrowerFirstName;
    private String borrowerLastName;
    private String borrowedBookName;
}
