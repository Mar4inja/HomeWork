package task_01;

public class ThirdStudentFilter implements  Filter{
    @Override
    public boolean test(Student student) {
        return student.getAverageRate() <= 3;
    }
}
