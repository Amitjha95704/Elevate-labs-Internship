package LiberaryManagementSystem;

public class Main {
     public static void main(String[] args) {
        Library library = new Library();

        // Add sample data
        Book b1 = new Book("Java Programming", "Author A", "ISBN001");
        Book b2 = new Book("Python Basics", "Author B", "ISBN002");
        library.addBook(b1);
        library.addBook(b2);

        User u1 = new User("Alice", "U001");
        User u2 = new User("Bob", "U002");
        library.addUser(u1);
        library.addUser(u2);

        // Example borrow & return
        library.borrowBook("ISBN001", "U001");
        library.returnBook("ISBN001", "U001");
    }
}
