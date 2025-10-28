package LiberaryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Library {
 private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user);
    }

    public void borrowBook(String isbn, String userId) {
        Book book = findBookByIsbn(isbn);
        User user = findUserById(userId);

        if (book == null) {
            System.out.println("Book with ISBN " + isbn + " not found.");
            return;
        }
        if (user == null) {
            System.out.println("User with ID " + userId + " not found.");
            return;
        }
        if (!book.isAvailable()) {
            System.out.println("Sorry, book is already issued.");
            return;
        }

        book.setAvailable(false);
        user.borrowBook(book);
        System.out.println(user.getName() + " successfully borrowed " + book.getTitle());
    }

    public void returnBook(String isbn, String userId) {
        Book book = findBookByIsbn(isbn);
        User user = findUserById(userId);

        if (book == null) {
            System.out.println("Book with ISBN " + isbn + " not found.");
            return;
        }
        if (user == null) {
            System.out.println("User with ID " + userId + " not found.");
            return;
        }

        if (book.isAvailable()) {
            System.out.println("Book is already marked as available in library.");
            return;
        }

        user.returnBook(book);
        book.setAvailable(true);
        System.out.println(user.getName() + " successfully returned " + book.getTitle());
    }

    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("Library Books:");
        for (Book b : books) {
            System.out.println(" - " + b);
        }
    }

    public void showAllUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }
        System.out.println("Registered Users:");
        for (User u : users) {
            System.out.println(" - " + u);
        }
    }

    private Book findBookByIsbn(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equalsIgnoreCase(isbn))
                return b;
        }
        return null;
    }

    private User findUserById(String userId) {
        for (User u : users) {
            if (u.getUserId().equalsIgnoreCase(userId))
                return u;
        }
        return null;
    }
}