import java.util.Scanner;

public class AdminActions {
    //prompt admin to enter how many students he wants to save.
    public int numberOfStudents;

    public void startAdminActions() {
        System.out.println("=====================");
        System.out.println("How many students do you want to add to the database? ");

        Scanner scanner = new Scanner(System.in);
        numberOfStudents = scanner.nextInt();
        scanner.nextLine();

        for (int idx = 0; idx < this.numberOfStudents; idx++) {
            Student student = new Student();

            int i = idx + 1;

            System.out.println("Enter name of student: " + 1);
            student.setName(scanner.nextLine());

            System.out.println("Enter grade year of student: " + i);
            student.setGradeYear(scanner.nextInt());
            scanner.nextLine();

            student.setStudent(student.getName(), student.getGradeYear());
        }

        System.out.println();
        Student student = new Student();
        student.displayStudentList();

        //System.out.println("Student name: " + student.getName() + ".\nStudent year: " + student.getGradeYear() );

    }
}
