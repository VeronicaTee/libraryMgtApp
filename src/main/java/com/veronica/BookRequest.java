package com.veronica;

import com.veronica.utils.RequestStatus;
import lombok.Data;

import static com.veronica.utils.RequestStatus.PENDING;

@Data
public class BookRequest {
    private String bookName;
    private Patrons patron;
    private RequestStatus status = PENDING;

    public BookRequest() {
    }

    public BookRequest(String bookName, Patrons patron) {
        this.bookName = bookName;
        this.patron = patron;
    }
}
