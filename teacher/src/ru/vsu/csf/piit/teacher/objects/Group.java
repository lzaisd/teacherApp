package ru.vsu.csf.piit.teacher.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Group {
    private final int ID;
    private final int num;

    private static final List<Integer> usedIDs = new ArrayList<>();

    public Group(int num) {
        this.ID = genID();;
        this.num = num;
    }

    public int getID() {
        return ID;
    }

    public int getNum() {
        return num;
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
        return "Group{" +
                "ID=" + ID +
                ", num=" + num +
                '}';
    }
}
