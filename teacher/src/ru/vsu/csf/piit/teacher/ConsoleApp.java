package ru.vsu.csf.piit.teacher;

import ru.vsu.csf.piit.teacher.controller.GroupController;
import ru.vsu.csf.piit.teacher.controller.StudentController;
import ru.vsu.csf.piit.teacher.objects.Group;
import ru.vsu.csf.piit.teacher.objects.Student;

import java.util.List;
import java.util.Scanner;

public class ConsoleApp {
    private static Scanner in = new Scanner(System.in);
    private static GroupController groups = new GroupController();
    private static StudentController students = new StudentController();

    public static void startConsoleApp() {
        initGroups();
        initStudents();
        while (true) {
            outputCommands();
            executeCommand();
        }
    }

    private static void outputCommands() {
        System.out.println("""
                ¬ведите команду:\s
                 1 - показать все группы\s
                 2 - найти группу по ID\s
                 3 - удалить группу по ID\s
                 4 - добавить группу
                 5 - показать студентов по номеру группы\s
                 6 - найти студента по ID\s
                 7 - удалить студента по ID\s
                 8 - добавить студента\s
                 9 - изменить статус задачи у студента\s
                 10 - завершить программу""");
    }

    private static void executeCommand() {
        String command = in.next();
        switch (command) {
            case ("1"):
                System.out.println(groups.getAllGroups());
                break;
            case ("2"):
                System.out.println(getGroupByID());
                break;
            case ("3"):
                System.out.println(deleteGroupByID() + " удалена");
                break;
            case ("4"):
                System.out.println(addGroup() + " добавлена");
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
                System.out.println("Ќеизвестна€ команда");
                break;
        }

    }

    private static Student changeTaskStatus() {
        System.out.println("¬ведите через пробел ID студента, номер задачи и 1, чтобы отметить задачу сданной, 0 - не сданной");
        String ID = in.next();
        String num = in.next();
        String isPassed = in.next();
        return students.changeTaskStatusByStudentID(Integer.parseInt(ID), Integer.parseInt(num), Integer.parseInt(isPassed) == 1);
    }

    private static Student addStudent() {
        System.out.println("¬ведите фамилию студента и номер группы через пробел");
        String surname = in.next();
        String num = in.next();
        return students.addStudent(surname, Integer.parseInt(num));
    }

    private static Student deleteStudentByID() {
        System.out.println("¬ведите ID студента");
        String command = in.next();
        return students.deleteStudentByID(Integer.parseInt(command));
    }

    private static Student getStudentByID() {
        System.out.println("¬ведите ID студента");
        String command = in.next();
        return students.getStudentByID(Integer.parseInt(command));
    }

    private static List<Student> getStudentsByGroup() {
        System.out.println("¬ведите номер группы");
        String command = in.next();
        return students.getStudentsByGroup(Integer.parseInt(command));
    }

    private static Group addGroup() {
        System.out.println("¬ведите номер группы");
        String num = in.next();
        return groups.addGroup(Integer.parseInt(num));
    }

    private static Group getGroupByID() {
        System.out.println("¬ведите ID группы");
        String command = in.next();
        return groups.getGroupByID(Integer.parseInt(command));
    }

    private static Group deleteGroupByID() {
        System.out.println("¬ведите ID группы");
        String command = in.next();
        return groups.deleteGroupByID(Integer.parseInt(command));
    }

    private static void initGroups() {
        groups.getAllGroups().add(new Group(1));
        groups.getAllGroups().add(new Group( 2));
        groups.getAllGroups().add(new Group(3));
        groups.getAllGroups().add(new Group(4));
    }

    private static void initStudents() {
        students.getAllStudents().add(new Student("јпрпор", 1));
        students.getAllStudents().add(new Student("ƒророа", 1));
        students.getAllStudents().add(new Student("÷жаава", 2));
        students.getAllStudents().add(new Student("Ёоавоа", 2));
        students.getAllStudents().add(new Student("јпрпор", 2));
        students.getAllStudents().add(new Student("¬авпапп", 3));
        students.getAllStudents().add(new Student("…апаррп", 4));
    }
}
