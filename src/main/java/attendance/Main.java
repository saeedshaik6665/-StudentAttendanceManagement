package attendance;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AttendanceManager manager =
                new AttendanceManager();

        while (true) {

            System.out.println();
            System.out.println(
                    "=========================================="
            );
            System.out.println(
                    "   STUDENT ATTENDANCE MANAGEMENT SYSTEM"
            );
            System.out.println(
                    "=========================================="
            );

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Mark Attendance");
            System.out.println("5. View Attendance");
            System.out.println("6. Attendance Percentage");
            System.out.println("7. Delete Student");
            System.out.println("8. Exit");

            System.out.print("\nEnter your choice: ");

            int choice;

            try {

                choice = scanner.nextInt();

            } catch (Exception e) {

                System.out.println(
                        "Please enter a valid number."
                );

                scanner.nextLine();
                continue;
            }

            switch (choice) {

                case 1:

                    System.out.print(
                            "Enter student ID: "
                    );

                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print(
                            "Enter student name: "
                    );

                    String name =
                            scanner.nextLine();

                    System.out.print(
                            "Enter course: "
                    );

                    String course =
                            scanner.nextLine();

                    if (manager.studentExists(id)) {

                        System.out.println(
                                "Student ID already exists."
                        );

                    } else {

                        Student student =
                                new Student(
                                        id,
                                        name,
                                        course
                                );

                        manager.addStudent(student);
                    }

                    break;

                case 2:

                    manager.viewStudents();

                    break;

                case 3:

                    System.out.print(
                            "Enter student ID: "
                    );

                    int searchId =
                            scanner.nextInt();

                    manager.searchStudent(searchId);

                    break;

                case 4:

                    System.out.print(
                            "Enter student ID: "
                    );

                    int attendanceId =
                            scanner.nextInt();

                    scanner.nextLine();

                    System.out.print(
                            "Enter status (Present/Absent): "
                    );

                    String status =
                            scanner.nextLine();

                    if (!status.equalsIgnoreCase("Present")
                            && !status.equalsIgnoreCase("Absent")) {

                        System.out.println(
                                "Invalid status. " +
                                "Enter Present or Absent."
                        );

                    } else {

                        manager.markAttendance(
                                attendanceId,
                                status
                        );
                    }

                    break;

                case 5:

                    manager.viewAttendance();

                    break;

                case 6:

                    System.out.print(
                            "Enter student ID: "
                    );

                    int percentageId =
                            scanner.nextInt();

                    manager.calculatePercentage(
                            percentageId
                    );

                    break;

                case 7:

                    System.out.print(
                            "Enter student ID: "
                    );

                    int deleteId =
                            scanner.nextInt();

                    manager.deleteStudent(deleteId);

                    break;

                case 8:

                    System.out.println(
                            "\nThank you for using " +
                            "Student Attendance Management System!"
                    );

                    scanner.close();
                    return;

                default:

                    System.out.println(
                            "Invalid choice!"
                    );
            }
        }
    }
}