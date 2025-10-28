package LiberaryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class User {
     private String name;
    private String userId;
    private List<Book> borrowedBooks;

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getUserId() { return userId; }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return name + " (User ID: " + userId + ")";
    }

    public void showBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println(name + " has not borrowed any books.");
            return;
        }
        System.out.println(name + "'s Borrowed Books:");
        for (Book b : borrowedBooks) {
            System.out.println(" - " + b);
        }
    }
}
  