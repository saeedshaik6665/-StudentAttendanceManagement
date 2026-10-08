package attendance;

public class Student {

    private int id;
    private String name;
    private String course;

    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public void displayStudent() {
        System.out.println(
                "ID: " + id +
                " | Name: " + name +
                " | Course: " + course
        );
    }
}