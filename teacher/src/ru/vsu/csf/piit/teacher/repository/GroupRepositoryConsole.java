package ru.vsu.csf.piit.teacher.repository;

import ru.vsu.csf.piit.teacher.objects.Group;

import java.util.List;

public class GroupRepositoryConsole implements GroupRepository {
    private List<Group> groups;

    public GroupRepositoryConsole(List<Group> groups) {
        this.groups = groups;
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
    public Group addGroup(int ID, int num) {
        Group g = new Group(ID, num);
        groups.add(g);
        return g;
    }
}
