package task_01;

public class FirstStudentFilter implements Filter {

    @Override
    public boolean test(Student student) {

       return student.getCourse() >= 3 && student.getAverageRate() >= 4.5;

    }
}
