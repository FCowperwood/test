package com.epam.automation.exceptions.medicaluniversity.university;

import com.epam.automation.exceptions.medicaluniversity.Runner;

import java.util.*;

public class Student {

    private int id;
    private String faculty;
    private String group;
    private String name;
    private String lastName;
    private String fathersName;
    private String address;
    private Map<String, Integer> subjects;

    public Student() {
    }

    public Student(int id, String faculty, String group, String name, String lastName, String fathersName, String address, Map subjects) {
        this.id = id;
        this.faculty = faculty;
        this.group = group;
        this.name = name;
        this.lastName = lastName;
        this.fathersName = fathersName;
        this.address = address;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Map<String, Integer> getSubjects() {
        return subjects;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

}
