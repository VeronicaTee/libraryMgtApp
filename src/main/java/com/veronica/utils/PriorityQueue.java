package com.veronica.utils;

import com.veronica.BookRequest;
import com.veronica.exceptions.EmptyQueueException;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {
    private List<BookRequest> queue = new ArrayList<>();

    public void offer(BookRequest bookRequest) {
        for (int index = 0; index < queue.size(); index++) {
            BookRequest bookRequest1 = queue.get(index);

            if (bookRequest1.getBookName().equalsIgnoreCase(bookRequest.getBookName())) {
                if (bookRequest1.getPatron().getRank() < bookRequest.getPatron().getRank()) {
                    queue.add(index, bookRequest);
                } else {
                    queue.add(bookRequest);
                }
                return;
            }
        }
        queue.add(bookRequest);

    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public BookRequest poll () {
        if (queue.isEmpty())
            throw new EmptyQueueException("Veronica's queue is empty 😡!");
        return queue.remove(0);
    }

    public BookRequest peek () {
        if (queue.isEmpty()) return null;
        return queue.get(0);
    }

    @Override
    public String toString() {
        return "PriorityQueue{" +
                "queue=" + queue +
                '}';
    }
}
