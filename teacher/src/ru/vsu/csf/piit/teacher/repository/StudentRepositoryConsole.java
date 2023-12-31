package ru.vsu.csf.piit.teacher.repository;

import ru.vsu.csf.piit.teacher.objects.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryConsole implements StudentRepository{
    private static StudentRepositoryConsole INSTANCE;
    private List<Student> students;

    private StudentRepositoryConsole() {
        this.students = new ArrayList<Student>();
    }

    public static StudentRepositoryConsole getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new StudentRepositoryConsole();
        }
        return INSTANCE;
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public List<Student> getStudentsByGroup(int num_group) {
        List<Student> s_group = new ArrayList<>();
        for (Student s : students) {
            if (s.getNumGroup() == num_group) {
                s_group.add(s);
            }
        }
        return s_group;
    }

    @Override
    public Student getStudentByID(int ID) {
        for (Student s : students) {
            if (s.getID() == ID) {
                return s;
            }
        }
        return null;
    }

    @Override
    public Student deleteStudentByID(int ID) {
        Student s = getStudentByID(ID);
        students.remove(s);
        return s;
    }

    @Override
    public Student addStudent(String surname, int num_group) {
        Student s = new Student(surname, num_group);
        students.add(s);
        return s;
    }

    @Override
    public Student changeTaskStatusByStudentID(int ID, int num_task, boolean isPassed) {
        Student s = getStudentByID(ID);
        s.changeTaskStatus(num_task, isPassed);
        return s;
    }
}
