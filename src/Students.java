import java.util.ArrayList;

class Student {
    //student will probably have to login using their student id

    private String name;
    private String studentId;
    private int gradeYear;
    private double balance = 0;
    private ArrayList<String> courses = new ArrayList<>();
    private static ArrayList<Student> studentArray = new ArrayList<>();
    private static final int CourseCost = 600;
    private static Integer userId = 1000;

    public Student() {};

    public Student(String name, int gradeYear, String id) {
        this.name = name;
        this.gradeYear = gradeYear;
        this.studentId = id;
    }

    public void setStudent(String name, Integer year) {
        String id = year.toString() + userId.toString();

        studentArray.add(new Student(name, year, id));
    }

    public boolean searchStudentList(Student student) {
        return studentArray.contains(student);
    }

    public void displayStudentList() {
        for (Student std : studentArray) {
            System.out.println("=========================");
            System.out.println("Name: " + std.name);
            System.out.println("Grade Year: " + std.gradeYear);
            System.out.println("Student ID: " + std.studentId);

            System.out.println();
        }
    }

    public void fundAccount(double amount) {
        this.balance += amount;
    }

    public void payTuition(double amount) {
        this.balance -= amount;
    }

    public void enrollInCourse(String course) {
        courses.add(course);
    }

    public void displayCourses() {
        for (String crs : courses) {
            System.out.println("=========================");
            System.out.println("Name: " + crs);
            System.out.println();
        }
    }

    public void displayStudent(Student std) {
        System.out.println("=========================");
        System.out.println("Name: " + std.name);
        System.out.println("Grade Year: " + std.gradeYear);
        System.out.println("Student ID: " + std.studentId);

        System.out.println();
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGradeYear() {
        return gradeYear;
    }

    public void setGradeYear(int gradeYear) {
        this.gradeYear = gradeYear;
    }
}
