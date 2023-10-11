package ru.vsu.csf.piit.teacher.repository;

import ru.vsu.csf.piit.teacher.objects.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupRepositoryConsole implements GroupRepository {
    private static GroupRepositoryConsole INSTANCE;
    private List<Group> groups;

    private GroupRepositoryConsole() {
        this.groups = new ArrayList<Group>();
    }

    public static GroupRepositoryConsole getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new GroupRepositoryConsole();
        }
        return INSTANCE;
    }

    @Override
    public List<Group> getAllGroups() {
        return groups;
    }

    @Override
    public Group getGroupByID(int ID) {
        for (Group g : groups) {
            if (g.getID() == ID) {
                return g;
            }
        }
        return null;
    }

    @Override
    public Group deleteGroupByID(int ID) {
        Group g = getGroupByID(ID);
        groups.remove(getGroupByID(ID));
        return g;
    }

    @Override
    public Group addGroup(int num) {
        Group g = new Group(num);
        groups.add(g);
        return g;
    }
}
