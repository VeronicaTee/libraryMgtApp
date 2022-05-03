package com.veronica;

import com.veronica.utils.RequestStatus;
import lombok.Data;

import static com.veronica.utils.RequestStatus.PENDING;

/**
 * This class handles the request for books by patrons
 */
@Data
public class BookRequest {
    private String bookName;
    private Patrons patron;
    private RequestStatus status = PENDING;


    /**
     * To create a new book request
     */
    public BookRequest() {
    }

    /**
     * To create a new book request
     * @param bookName Name of book to be borrowed
     * @param patron Patron's information
     */
    public BookRequest(String bookName, Patrons patron) {
        this.bookName = bookName;
        this.patron = patron;
    }

}
