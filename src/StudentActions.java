import java.util.Scanner;

public class StudentActions {
    private String activeStudentName;

    public void signIn(String name, int gradeYear, String studentId) {
        Student student = new Student();
        this.activeStudentName = name;

        if(student.searchStudentList(new Student(name, gradeYear, studentId))) {
            startStudentActions(student);
        } else {
            System.out.println("You have provided invalid user details.");
        }
    }

    public void startStudentActions(Student student) {
        char option;

        System.out.println("Hello " + student.getName());
        System.out.println();
        System.out.println("Welcome to your dashboard!");
        System.out.println();
        System.out.println("What would you like to do today?");
        System.out.println();
        System.out.println("A. View balance.");
        System.out.println("B. Enroll in a course.");
        System.out.println("C. Pay tuition.");
        System.out.println("D. Fund account.");
        System.out.println("E. View profile.");
        System.out.println("F. Exit.");

        do {

            System.out.println();
            System.out.println("Enter an option: ");

            Scanner optionScanner = new Scanner(System.in);
            option = optionScanner.next().charAt(0);
            option = Character.toUpperCase(option);

            System.out.println();

            switch (option) {
                case 'A' -> {
                    System.out.println("===============================");
                    System.out.println();
                    System.out.println("Your balance is £" + student.getBalance());
                    System.out.println();
                    System.out.println("================================");
                }
                case 'B' -> {
                    System.out.println("===============================");
                    System.out.println("Enter course to enroll in:");
                    String course = optionScanner.nextLine();

                    student.enrollInCourse(course);
                    System.out.println("Your courses are: ");

                    student.displayCourses();
                    System.out.println("================================");
                }
                case 'C' -> {
                    System.out.println("===============================");
                    System.out.println("Enter amount to withdraw:");
                    double withdrawAmount = optionScanner.nextDouble();

                    if(student.getBalance() < withdrawAmount) System.out.println("Invalid input. You need to fund your account.");

                    student.payTuition(withdrawAmount);
                    System.out.println("Your balance is now " + student.getBalance());
                    System.out.println("================================");
                }
                case 'D' -> {
                    System.out.println("===============================");
                    System.out.println("Enter amount to fund:");
                    double fundAmount = optionScanner.nextDouble();

                    if(fundAmount < 1000) System.out.println("Invalid input. Minimum amount to fund is £1000.");

                    student.fundAccount(fundAmount);
                    System.out.println("Your balance is now " + student.getBalance());
                    System.out.println("================================");
                }
                case 'E' -> {
                    System.out.println("====================================");
                    student.displayStudent(student);
                    System.out.println("====================================");
                }
                case 'F' -> {
                    System.out.println("====================================");
                    System.out.println("Good bye...");
                    System.out.println("====================================");
                }
                default -> System.out.println("Error: invalid option. Please enter A, B, C, D, or E to exit.");
            }
        } while (option != 'F');
    }
}
