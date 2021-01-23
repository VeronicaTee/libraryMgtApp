package com.veronica;

import com.veronica.exceptions.BookNotFoundException;
import com.veronica.exceptions.EmptyQueueException;
import com.veronica.utils.PriorityQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.veronica.utils.RequestStatus.BORROWED;
import static com.veronica.utils.RequestStatus.DECLINED;


// TODO
// Write tests
// Handle AOBs
// UML

public class Library {

    private Map<String, Integer> allBooks = new HashMap<>();
    private PriorityQueue queue = new PriorityQueue();
    private List<Lender> lenders = new ArrayList<>();


    public int getQueueSize() {
        return queue.size();
    }

    public int addNewRequest(BookRequest bookRequest){
        queue.offer(bookRequest);
        return queue.size();
    }

    public void processRequest(){
        System.out.println("processing requests!!");
        BookRequest request = null;
        try {
            while (true) {
                request = queue.poll();
                System.out.println(request);
                getBook(request.getBookName());
                request.getPatron().addBook(request.getBookName().toLowerCase());
                request.setStatus(BORROWED);
                addLender(request.getPatron().getFirstName(), request.getPatron().getLastName(), request.getBookName());

            }

        } catch (EmptyQueueException e) {
            System.out.println(e.getMessage());

        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
            request.setStatus(DECLINED);
        }
    }

    private void addLender(String firstName, String lastName, String bookName) {
        Lender lender = new Lender();
        lender.setFirstName(firstName);
        lender.setLastName(lastName);
        lender.setBookName(bookName);

        lenders.add(lender);
    }

    private void removeLender(String firstName, String lastName, String bookName) {
        if (lenders.isEmpty()) return;
        int indexToRemove = 0;
        for (int index = 0; index < lenders.size(); index++ ){
            if (lenders.get(index).getFirstName().equalsIgnoreCase(firstName) &&
            lenders.get(index).getLastName().equalsIgnoreCase(lastName) &&
            lenders.get(index).getBookName().equalsIgnoreCase(bookName)) {
                indexToRemove = index;
            }
        }

        lenders.remove(indexToRemove);

//        lenders.stream().filter(lender -> lender.getFirstName().equalsIgnoreCase(firstName) &&
//                lender.getLastName().equalsIgnoreCase(lastName) &&
//                lender.getBookName().equalsIgnoreCase(bookName)).collect(Collectors.toList());
    }

    private void getBook(String bookname) {
        bookname = bookname.toLowerCase();

        if (allBooks.containsKey(bookname)){
            allBooks.put(bookname, allBooks.get(bookname) - 1);
        } else {
            throw new BookNotFoundException("Book is not available!");
        }
    }

    public void addNewBook (String bookName, int noOfCopies) {
        allBooks.put(bookName.toLowerCase(), noOfCopies);
    }

    public void addNewBook (String bookName) {
        allBooks.put(bookName.toLowerCase(), 2);
    }

    public void returnBook (String firstName, String lastname, String bookName) throws BookNotFoundException {
        bookName = bookName.toLowerCase();

        if (allBooks.containsKey(bookName)){
            Integer bookcount = allBooks.get(bookName);
            if (bookcount <= 0) {
                throw new BookNotFoundException("Book is not available!");
            }
            allBooks.put(bookName, allBooks.get(bookName) + 1);
            removeLender(firstName, lastname, bookName);
        } else allBooks.put(bookName, 1);
    }

    public Map<String, Integer> allBooks() {
        return allBooks;
    }

    public Map<String, Integer> getBooks (){
        return allBooks();
    }
}

