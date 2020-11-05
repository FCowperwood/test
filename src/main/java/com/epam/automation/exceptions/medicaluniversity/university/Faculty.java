package com.epam.automation.exceptions.medicaluniversity.university;

import java.util.ArrayList;
import java.util.List;

public class Faculty {

    private String name;
    private List<Group> groups;

    public Faculty(String name) {
        this.name = name;
        this.groups = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) {
        this.groups.add(group);
    }
}
