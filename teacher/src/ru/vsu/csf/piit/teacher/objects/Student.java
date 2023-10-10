package ru.vsu.csf.piit.teacher.objects;

import java.util.Arrays;

public class Student {
    private final int ID;
    private String surname;
    private boolean[] tasks;
    private int numGroup;

    public Student(int ID, String surname, int numGroup) {
        this.ID = ID;
        this.surname = surname;
        this.numGroup = numGroup;
        this.tasks = new boolean[]{false, false, false};
    }

    public int getID() {
        return ID;
    }

    public String getFIO() {
        return surname;
    }

    public int getNumGroup() {
        return numGroup;
    }

    public boolean[] getTasks() {
        return tasks;
    }

    public void setNum_group(int numGroup) {
        this.numGroup = numGroup;
    }

    public void changeTaskStatus(int taskNumber, boolean isPassed) {
        tasks[taskNumber - 1] = isPassed;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", surname='" + surname + '\'' +
                ", tasks=" + Arrays.toString(tasks) +
                ", numGroup=" + numGroup +
                '}';
    }
}
