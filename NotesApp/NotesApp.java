package NotesApp;
import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NotesApp {
    private static final String FILE_NAME = "notes.txt";
    private List<String> notes;
    
    public NotesApp() {
        notes = new ArrayList<>();
        loadNotesFromFile();
    }

    // Load notes from file when program starts
    private void loadNotesFromFile() {
        try (FileReader fr = new FileReader(FILE_NAME);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                notes.add(line);
            }
        } catch (FileNotFoundException e) {
            // File doesn't exist yet, ignore
        } catch (IOException e) {
            System.out.println("Error reading notes file: " + e.getMessage());
        }
    }

    // Save notes to file
    private void saveNotesToFile() {
        try (FileWriter fw = new FileWriter(FILE_NAME);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (String note : notes) {
                bw.write(note);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving notes: " + e.getMessage());
        }
    }

    // Add a new note
    public void addNote(String note) {
        notes.add(note);
        saveNotesToFile();
    }

    // Display all notes
    public void viewNotes() {
        if (notes.isEmpty()) {
            System.out.println("No notes found.");
            return;
        }
        System.out.println("Your Notes:");
        for (int i = 0; i < notes.size(); i++) {
            System.out.println((i + 1) + ". " + notes.get(i));
        }
    }

    // Main menu for interaction
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Notes App ---");
            System.out.println("1. View Notes");
            System.out.println("2. Add Note");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    viewNotes();
                    break;
                case "2":
                    System.out.print("Enter your note: ");
                    String note = sc.nextLine();
                    addNote(note);
                    System.out.println("Note added.");
                    break;
                case "3":
                    System.out.println("Exiting Notes App. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        }
    }

    public static void main(String[] args) {
        NotesApp app = new NotesApp();
        app.run();
    }
}