package ru.vsu.csf.piit.teacher.repository;

import ru.vsu.csf.piit.teacher.objects.Group;

import java.util.List;

public interface GroupRepository {
    List<Group> getAllGroups();
    Group getGroupByID(int ID);
    Group deleteGroupByID(int ID);
    Group addGroup(int ID, int num);
    
}
