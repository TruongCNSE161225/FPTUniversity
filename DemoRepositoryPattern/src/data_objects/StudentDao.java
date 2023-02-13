package data_objects;

import business_objects.Student;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class StudentDao implements IStudentDao {

    List<Student> students;

    public StudentDao() {
        students = new ArrayList<Student>();
        Student Robert = new Student(1, "Robert", "Robert@gmail.com");
        Student John = new Student(2, "John", "John@gmail.com");
        students.add(Robert);
        students.add(John);
    }

    @Override
    public List<Student> getAllStudent() {
        return students;
    }

    @Override
    public Student getStudent(int id) {
        Student student = students.stream()
                .filter(s -> s.getId() == id)
                .findAny()
                .orElse(null);
        return student;
    }

    @Override
    public void updateStudent(Student student) {
        var std = getStudent(student.getId());
        std = student;
        System.out.println("Student ID: " + student.getId() + ", updated into the database");
    }

}
