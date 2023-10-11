package ru.vsu.csf.piit.teacher.controller;

import ru.vsu.csf.piit.teacher.objects.Student;
import ru.vsu.csf.piit.teacher.repository.StudentRepositoryConsole;

import java.util.List;

public class StudentController {
    private static StudentRepositoryConsole students = StudentRepositoryConsole.getInstance();

    public StudentController() {
    }

    public List<Student> getAllStudents() {
        return students.getAllStudents();
    }

    public List<Student> getStudentsByGroup(int num_group) {
        return students.getStudentsByGroup(num_group);
    }

    public Student getStudentByID(int ID) {
        return students.getStudentByID(ID);
    }

    public Student deleteStudentByID(int ID) {
        return students.deleteStudentByID(ID);
    }

    public Student addStudent(String surname, int num_group) {
        return students.addStudent(surname, num_group);
    }

    public Student changeTaskStatusByStudentID(int ID, int num_task, boolean isPassed) {
        return students.changeTaskStatusByStudentID(ID, num_task, isPassed);
    }
}
