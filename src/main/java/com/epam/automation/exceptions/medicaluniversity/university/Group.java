package com.epam.automation.exceptions.medicaluniversity.university;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private String name;
    private String facultyName;
    private List<Student> students;

    public Group(String name) {
        this.name = name;
    }

    public Group(String name, String facultyName) {
        this.name = name;
        this.facultyName = facultyName;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
}
