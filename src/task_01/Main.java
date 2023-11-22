package task_01;
// home work - 3 filters.. one with lambda, another with anonymous class and one more with usual class

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("James", 24, 4, 4.79, Degree.MASTER));
        students.add(new Student("Antony", 21, 1, 3.90, Degree.MASTER));
        students.add(new Student("Luiss", 19, 2, 2.50, Degree.MASTER));
        students.add(new Student("Kiril", 22, 3, 4.20, Degree.MASTER));
        students.add(new Student("John", 21, 1, 4.95, Degree.MASTER));
        students.add(new Student("Peter", 20, 2, 3, Degree.MASTER));
        students.add(new Student("Kylie", 28, 5, 4.90, Degree.BACHELOR));
        students.add(new Student("Lina", 33, 5, 4.82, Degree.BACHELOR));
        students.add(new Student("Oren", 21, 1, 5, Degree.MASTER));

        System.out.println("List of all Students: ");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
        System.out.println("Filter students by course and grade point average");
        StudentService.printStudents(students, new FirstStudentFilter());
        System.out.println();

        System.out.println("Filter by age and grade");
        StudentService.printStudents(students, new SecondStudentFilter());
        System.out.println();

        System.out.println("Filter by name and course");
        StudentService.printStudents(students, new Filter() { // anonymous class
            @Override
            public boolean test(Student student) {
                return student.getName().length() > 4 && student.getCourse() % 2 != 0;
            }
        });
        System.out.println();
        System.out.println("Filter by Name -A- and age form 21");
        StudentService.printStudents(students, x -> x.getName().startsWith("A") && x.getAge() >= 21); // Lambda // make the same
        System.out.println("*".repeat(20));

        System.out.println();
        System.out.println("Filter by averageRate <= 3");
        System.out.println("Need to leave or university");
        StudentService.printStudents(students, new ThirdStudentFilter()); // by average rate. If less than 3, nedd leave our university
        System.out.println();

        System.out.println("*".repeat(20));
        System.out.println("If average rate is 4.9 or more, than we give you pramie");
        StudentService.printStudents(students, new Filter() {

            @Override
            public boolean test(Student student) {
                if (student.getCourse() <= 2 && student.getAverageRate() >= 4.8) {
                    System.out.println("Pramie 200 euro " + " for " + student.getName());
                } else if (student.getCourse() >= 2 && student.getAverageRate() >= 3) {
                    System.out.println("Keep learning " + student.getName());
                } else {
                    System.out.println("We need to talk about your future in this university " + student.getName());
                }
                return false;
            }
        });
        System.out.println();
        System.out.println("Filter by Names last letter -n- and age form 25");
        StudentService.printStudents(students, x -> x.getName().endsWith("e") && x.getAge() >= 25);

    }

}