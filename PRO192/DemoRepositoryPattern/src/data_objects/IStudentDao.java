package data_objects;

import business_objects.Student;
import java.util.List;

public interface IStudentDao {

    public List<Student> getAllStudent();

    public Student getStudent(int id);

    public void updateStudent(Student student);

    public void deleteStudent(Student student);
}
