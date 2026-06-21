package model;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private List<Student> students;

    public StudentDAO() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student findStudent(int id) {
        for(Student s : students) {
            if(s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public boolean deleteStudent(int id) {
        Student s = findStudent(id);

        if(s != null) {
            students.remove(s);
            return true;
        }

        return false;
    }

    public boolean updateStudent(int id, String name, String department) {
        Student s = findStudent(id);

        if(s != null) {
            s.setName(name);
            s.setDepartment(department);
            return true;
        }

        return false;
    }
}
