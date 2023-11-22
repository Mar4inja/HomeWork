package task_01;

public class SecondStudentFilter  implements  Filter{
    @Override
    public boolean test(Student student) {
        return student.getAge() > 23 && student.getDegree().equals(Degree.MASTER);
    }
}
