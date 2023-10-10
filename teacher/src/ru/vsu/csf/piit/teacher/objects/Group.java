package ru.vsu.csf.piit.teacher.objects;

public class Group {
    private final int ID;
    private final int num;

    public Group(int ID, int num) {
        this.ID = ID;
        this.num = num;
    }

    public int getID() {
        return ID;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "Group{" +
                "ID=" + ID +
                ", num=" + num +
                '}';
    }
}
