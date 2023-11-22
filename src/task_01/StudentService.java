package task_01;

import java.util.List;

public class StudentService {

    public static void printStudents(List<Student> students, Filter filter) {
        for (Student student : students) {
            if (filter.test(student)) {
                System.out.println(student);
            }
        }

    }
}
