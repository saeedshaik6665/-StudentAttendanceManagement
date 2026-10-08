package attendance;

import java.time.LocalDate;
import java.util.ArrayList;

public class AttendanceManager {

    private ArrayList<Student> students;
    private ArrayList<Attendance> attendanceList;

    public AttendanceManager() {
        students = new ArrayList<>();
        attendanceList = new ArrayList<>();
    }

    // Add student
    public void addStudent(Student student) {

        students.add(student);

        System.out.println(
                "Student added successfully!"
        );
    }

    // View students
    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n========== STUDENTS ==========");

        for (Student student : students) {
            student.displayStudent();
        }
    }

    // Search student
    public void searchStudent(int id) {

        for (Student student : students) {

            if (student.getId() == id) {

                System.out.println("\nStudent Found:");
                student.displayStudent();

                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Check student
    public boolean studentExists(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return true;
            }
        }

        return false;
    }

    // Mark attendance
    public void markAttendance(int studentId, String status) {

        if (!studentExists(studentId)) {

            System.out.println("Student not found.");
            return;
        }

        Attendance attendance =
                new Attendance(
                        studentId,
                        LocalDate.now(),
                        status
                );

        attendanceList.add(attendance);

        System.out.println(
                "Attendance marked successfully!"
        );
    }

    // View attendance
    public void viewAttendance() {

        if (attendanceList.isEmpty()) {

            System.out.println(
                    "No attendance records found."
            );

            return;
        }

        System.out.println(
                "\n========== ATTENDANCE =========="
        );

        for (Attendance attendance : attendanceList) {
            attendance.displayAttendance();
        }
    }

    // Calculate attendance percentage
    public void calculatePercentage(int studentId) {

        if (!studentExists(studentId)) {

            System.out.println("Student not found.");
            return;
        }

        int total = 0;
        int present = 0;

        for (Attendance attendance : attendanceList) {

            if (attendance.getStudentId() == studentId) {

                total++;

                if (attendance.getStatus()
                        .equalsIgnoreCase("Present")) {

                    present++;
                }
            }
        }

        if (total == 0) {

            System.out.println(
                    "No attendance records found."
            );

            return;
        }

        double percentage =
                ((double) present / total) * 100;

        System.out.printf(
                "Attendance Percentage: %.2f%%%n",
                percentage
        );
    }

    // Delete student
    public void deleteStudent(int id) {

        Student studentToDelete = null;

        for (Student student : students) {

            if (student.getId() == id) {
                studentToDelete = student;
                break;
            }
        }

        if (studentToDelete == null) {

            System.out.println(
                    "Student not found."
            );

            return;
        }

        students.remove(studentToDelete);

        attendanceList.removeIf(
                attendance ->
                        attendance.getStudentId() == id
        );

        System.out.println(
                "Student deleted successfully!"
        );
    }
}