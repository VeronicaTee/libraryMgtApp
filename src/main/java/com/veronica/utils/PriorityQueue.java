package com.veronica.utils;

import com.veronica.BookRequest;
import com.veronica.exceptions.EmptyQueueException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Priority Queue to borrow books in order of Patrons' ranks.
 */

public class PriorityQueue {
    private List<BookRequest> queue = new ArrayList<>();

    /**
     * Sets up the Priority Queue, arranges request for the same book in order of ranks and adds to book request queue.
     * If there are no requests for the same book, requests are added in FIFO order.
     * @param bookRequest
     */
//    public void offer(BookRequest bookRequest) {
//        for (int index = 0; index < queue.size(); index++) {
//            BookRequest bookRequest1 = queue.get(index);
//
//            if (bookRequest1.getBookName().equalsIgnoreCase(bookRequest.getBookName())) {
//                if (bookRequest1.getPatron().getRank() < bookRequest.getPatron().getRank()) {
//                    queue.add(index, bookRequest);
//                } else {
//                    queue.add(bookRequest);
//                }
//                return;
//            }
//        }
//        queue.add(bookRequest);
//
//
////        queue.forEac;
//
//    }
    public Consumer<BookRequest> offer = (bookRequest) -> {
        Predicate<String> input = reqName -> reqName.equalsIgnoreCase(bookRequest.getBookName());
        for (int index = 0; index < queue.size(); index++) {
            BookRequest bookRequest1 = queue.get(index);

            if (input.test(bookRequest1.getBookName())) {
                if (bookRequest1.getPatron().getRank.get() < bookRequest.getPatron().getRank.get()) {
                    queue.add(index, bookRequest);
                } else {
                    queue.add(bookRequest);
                }
                return;
            }
        }
        queue.add(bookRequest);

    };

    /**
     *
     * @return the current size of the queue
     */
    public int size() {
        return queue.size();
    }

    /**
     *
     * @return queue is empty
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     *
     * @return the new queue, after the first request has been attended to and removed
     */
//    public BookRequest poll () {
//        if (queue.isEmpty())
//            throw new EmptyQueueException("Queue is empty 😡!");
//        return queue.remove(0);
//    }

    public Supplier<BookRequest> poll = () -> {
        if (queue.isEmpty())
            throw new EmptyQueueException("Queue is empty 😡!");
        return queue.remove(0);
    };


    @Override
    public String toString() {
        return "PriorityQueue{" +
                "queue=" + queue +
                '}';
    }
}
