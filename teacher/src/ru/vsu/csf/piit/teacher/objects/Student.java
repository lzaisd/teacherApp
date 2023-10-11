package ru.vsu.csf.piit.teacher.objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Student {
    private final int ID;
    private String surname;
    private boolean[] tasks;
    private int numGroup;

    private static final List<Integer> usedIDs = new ArrayList<>();

    public Student(String surname, int numGroup) {
        this.ID = genID();
        this.surname = surname;
        this.numGroup = numGroup;
        this.tasks = new boolean[]{false, false, false};
    }

    public int getID() {
        return ID;
    }

    public int getNumGroup() {
        return numGroup;
    }

    public void changeTaskStatus(int taskNumber, boolean isPassed) {
        tasks[taskNumber - 1] = isPassed;
    }

    private int genID() {
        Random random = new Random();
        int newID;
        do {
            newID = random.nextInt(100);
        } while (usedIDs.contains(newID));
        usedIDs.add(newID);
        return newID;
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
