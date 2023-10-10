package ru.vsu.csf.piit.teacher;

import ru.vsu.csf.piit.teacher.objects.Group;
import ru.vsu.csf.piit.teacher.objects.Student;
import ru.vsu.csf.piit.teacher.repository.GroupRepositoryConsole;
import ru.vsu.csf.piit.teacher.repository.StudentRepositoryConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleApp {
    private static Scanner in = new Scanner(System.in);
    private static GroupRepositoryConsole groups = new GroupRepositoryConsole(initGroups());
    private static StudentRepositoryConsole students = new StudentRepositoryConsole(initStudents());

    public static void startConsoleApp() {
        while (true) {
            outputCommands();
            executeCommand();
        }
    }

    private static void outputCommands(){
        System.out.println("""
                ������� �������:\s
                 1 - �������� ��� ������\s
                 2 - ����� ������ �� ID\s
                 3 - ������� ������ �� ID\s
                 4 - �������� ������
                 5 - �������� ��������� �� ������ ������\s
                 6 - ����� �������� �� ID\s
                 7 - ������� �������� �� ID\s
                 8 - �������� ��������\s
                 9 - �������� ������ ������ � ��������\s
                 10 - ��������� ���������""");
    }

    private static void executeCommand(){
        String command = in.next();
        switch (command) {
            case ("1"):
                System.out.println(groups.getAllGroups());
                break;
            case ("2"):
                System.out.println(getGroupByID());
                break;
            case ("3"):
                System.out.println(deleteGroupByID() + " �������");
                break;
            case ("4"):
                System.out.println(addGroup() + " ���������");
                break;
            case ("5"):
                System.out.println(getStudentsByGroup());
                break;
            case ("6"):
                System.out.println(getStudentByID());
                break;
            case ("7"):
                System.out.println(deleteStudentByID());
                break;
            case ("8"):
                System.out.println(addStudent());
                break;
            case ("9"):
                System.out.println(changeTaskStatus());
                break;
            case ("10"):
                System.exit(0);
            default:
                System.out.println("����������� �������");
                break;
        }

    }

    private static Student changeTaskStatus(){
        System.out.println("������� ����� ������ ID ��������, ����� ������ � 1, ����� �������� ������ �������, 0 - �� �������");
        String ID = in.next();
        String num = in.next();
        String isPassed = in.next();
        return students.changeTaskStatusByStudentID(Integer.parseInt(ID), Integer.parseInt(num), Integer.parseInt(isPassed) == 1);
    }

    private static Student addStudent(){
        System.out.println("������� ID ��������, ������� � ����� ������ ����� ������");
        String ID = in.next();
        String surname = in.next();
        String num = in.next();
        return students.addStudent(Integer.parseInt(ID), surname, Integer.parseInt(num));
    }

    private static Student deleteStudentByID(){
        System.out.println("������� ID ��������");
        String command = in.next();
        return students.deleteStudentByID(Integer.parseInt(command));
    }

    private static Student getStudentByID(){
        System.out.println("������� ID ��������");
        String command = in.next();
        return students.getStudentByID(Integer.parseInt(command));
    }

    private static List<Student> getStudentsByGroup(){
        System.out.println("������� ����� ������");
        String command = in.next();
        return students.getStudentsByGroup(Integer.parseInt(command));
    }

    private static Group addGroup(){
        System.out.println("������� ID � ����� ������ ����� ������");
        String ID = in.next();
        String num = in.next();
        return groups.addGroup(Integer.parseInt(ID), Integer.parseInt(num));
    }

    private static Group getGroupByID(){
        System.out.println("������� ID ������");
        String command = in.next();
        return groups.getGroupByID(Integer.parseInt(command));
    }

    private static Group deleteGroupByID(){
        System.out.println("������� ID ������");
        String command = in.next();
        return groups.deleteGroupByID(Integer.parseInt(command));
    }

    private static List<Group> initGroups(){
        List<Group> g = new ArrayList<>();
        g.add(new Group(100, 1));
        g.add(new Group(101, 2));
        g.add(new Group(102, 3));
        g.add(new Group(103, 4));
        return g;
    }
    private static List<Student> initStudents(){
        List<Student> s = new ArrayList<>();
        s.add(new Student(200, "������", 1));
        s.add(new Student(201, "������", 1));
        s.add(new Student(202, "������", 2));
        s.add(new Student(203, "������", 2));
        s.add(new Student(204, "������", 2));
        s.add(new Student(205, "�������", 3));
        s.add(new Student(206, "�������", 4));
        return s;
    }
}
