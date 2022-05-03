package com.veronica;

import com.veronica.exceptions.BookNotFoundException;
import com.veronica.exceptions.EmptyQueueException;
import com.veronica.utils.PriorityQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;

import static com.veronica.utils.RequestStatus.BORROWED;
import static com.veronica.utils.RequestStatus.DECLINED;

/**
 * Library class. This is where books are borrowed. All requests come from the Librarian.
 */
public class Library<availableBooks, allBooks> {

    private Map<String, Integer> allBooks = new HashMap<>();
    private PriorityQueue queue = new PriorityQueue();
    private List<Borrower> borrowers = new ArrayList<>();
    private static List<BorrowedBooks> borrowedBooks = new ArrayList<>();


    /**
     * @return Queue size.
     */

    public Supplier<Integer> getQueueSize = () -> queue.size();


    /**
     * @param bookRequest The book request details.
     * @return Queue size.
     */


    public Function<BookRequest, Integer> addNewRequest = bookRequest -> {
        queue.offer.accept(bookRequest);
        return queue.size();
    };


    /**
     * Processes requests to borrow books.
     */
    public void processRequest() {
        System.out.println("Currently processing requests!!");
        BookRequest request = null;
        try {
            while (true) {
                request = queue.poll.get();
                System.out.println(request);
                if (getBook.test(request.getBookName()) == true) {
                    request.getPatron().addToBorrowedBook.accept(request.getBookName().toLowerCase());
                    request.getPatron().addToBorrowers.accept(request.getBookName().toLowerCase());
                    request.setStatus(BORROWED);

                    System.out.println("Request processed!");

                    System.out.println(request);

                    addBorrower(request.getPatron().getFirstName(), request.getPatron().getLastName(), request.getBookName());
                    addBorrowedBook(request.getPatron().getFirstName(), request.getPatron().getLastName(), request.getBookName());
                } else {
                    request.setStatus(DECLINED);
                    System.out.println("Book taken!");
                    System.out.println(request);
                }
            }

        } catch (EmptyQueueException e) {
            System.out.println(e.getMessage());

        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
            request.setStatus(DECLINED);
            System.out.println(request);
        }
    }


    /**
     * @param firstName Patron's first name.
     * @param lastName  Patron's last name.
     * @param bookName  The name of the book borrowed.
     */

    private void addBorrower(String firstName, String lastName, String bookName) {
        Borrower borrower = new Borrower();
        borrower.setFirstName(firstName);
        borrower.setLastName(lastName);
        borrower.setBookName(bookName);

        borrowers.add(borrower);
    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param bookName
     */

    private void addBorrowedBook(String firstName, String lastName, String bookName) {
        BorrowedBooks borrowedBook = new BorrowedBooks();
        borrowedBook.setBorrowerFirstName(firstName);
        borrowedBook.setBorrowerLastName(lastName);
        borrowedBook.setBorrowedBookName(bookName);

        borrowedBooks.add(borrowedBook);
        System.out.println(borrowedBooks);
    }

    /**
     * @param firstName Patron's first name.
     * @param lastName  Patron's last name.
     * @param bookName  The name of the book returned.
     */
    private void removeBorrower(String firstName, String lastName, String bookName) {
        if (borrowers.isEmpty()) return;
        int indexToRemove = 0;


        borrowers.stream().filter(borrower -> borrower.getFirstName().equalsIgnoreCase(firstName) &&
                borrower.getLastName().equalsIgnoreCase(lastName) &&
                borrower.getBookName().equalsIgnoreCase(bookName)).collect(Collectors.toList());

        borrowers.remove(indexToRemove);
    }


    /**
     * Checks if book being requested is available.
     *
     * @param bookname The name of the book to be borrowed.
     * @return Boolean true or false.
     */

    private Predicate<String> getBook = bookname -> {
        bookname = bookname.toLowerCase();

        if (allBooks.containsKey(bookname)) {

            if ((allBooks.get(bookname)) < 1) {
                System.out.println("Request to borrow " + bookname + " has been declined!");
                return false;
            } else {
                System.out.println("Request to borrow " + bookname + " has been approved!");
                allBooks.put(bookname, allBooks.get(bookname) - 1);
                return true;
            }

        } else {
            throw new BookNotFoundException("Book is not available!");
        }
    };


    /**
     * To add a new book to the Library
     *
     * @param bookName  The name of the book to be added.
     * @param noOfCopies The number of copies of the book being added.
     */

    public BiConsumer<String, Integer> addNewBook = (bookName, Integer) -> allBooks.put(bookName.toLowerCase(), Integer);


    /**
     * @param firstName Patron's first name.
     * @param lastname  Patron's last name.
     * @param bookName  The name of the book to be returned.
     * @throws BookNotFoundException
     */

    public void returnBook(String firstName, String lastname, String bookName) throws BookNotFoundException {
        bookName = bookName.toLowerCase();

        if (allBooks.containsKey(bookName)) {
            allBooks.put(bookName, allBooks.get(bookName) + 1);
            removeBorrower(firstName, lastname, bookName);
        } else allBooks.put(bookName, 1);
    }


    /**
     * @return List of all books and their corresponding number of copies
     */

    public Map<String, Integer> allBooks() {
        return allBooks;
    }

//    () -> {return allBooks}
}

