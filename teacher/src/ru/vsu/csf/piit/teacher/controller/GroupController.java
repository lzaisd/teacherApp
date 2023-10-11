package ru.vsu.csf.piit.teacher.controller;

import ru.vsu.csf.piit.teacher.objects.Group;
import ru.vsu.csf.piit.teacher.repository.GroupRepositoryConsole;

import java.util.List;

public class GroupController {
    private static GroupRepositoryConsole groups = GroupRepositoryConsole.getInstance();

    public GroupController() {
    }

    public List<Group> getAllGroups() {
        return groups.getAllGroups();
    }

    public Group getGroupByID(int ID) {
        return groups.getGroupByID(ID);
    }

    public Group deleteGroupByID(int ID) {
        return groups.deleteGroupByID(ID);
    }

    public Group addGroup(int num) {
        return groups.addGroup(num);
    }
}
