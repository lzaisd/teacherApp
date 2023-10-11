package ru.vsu.csf.piit.teacher.repository;

import ru.vsu.csf.piit.teacher.objects.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> getAllStudents();
    List<Student> getStudentsByGroup(int num_group);
    Student getStudentByID(int ID);
    Student deleteStudentByID(int ID);
    Student addStudent(String FIO, int num_group);
    Student changeTaskStatusByStudentID(int ID, int num_task, boolean isPassed);
}
