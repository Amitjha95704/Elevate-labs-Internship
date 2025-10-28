package StudentManagementsystem;

import java.util.ArrayList;

public class StudentManager {
     private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    // Add new student
    public void addStudent(String id, String name, double marks) {
        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    // View all students
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Find student by ID
    private Student findStudent(String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) return s;
        }
        return null;
    }

    // Update student by ID
    public void updateStudent(String id, String newName, double newMarks) {
        Student student = findStudent(id);
        if (student != null) {
            student.setName(newName);
            student.setMarks(newMarks);
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    // Delete student by ID
    public void deleteStudent(String id) {
        Student student = findStudent(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }
}
