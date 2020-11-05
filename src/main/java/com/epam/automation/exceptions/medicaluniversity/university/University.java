package com.epam.automation.exceptions.medicaluniversity.university;

import com.epam.automation.exceptions.medicaluniversity.exceptions.NoSuchSubjectsException;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class University {

    private String name;
    private String rector;
    private List<Faculty> faculties;

    public University(String name, String rector, List<Faculty> faculties) {
        this.name = name;
        this.rector = rector;
        this.faculties = faculties;
    }

    public static void addStudentsToGroup(List<Group> groupList, List<Student> studentList) {
//        for (int i = 0; i < groupList.size(); i++) {
//            for (int j = 0; j < studentList.size(); j++) {
//                if (studentList.get(j).getGroup().equals(groupList.get(i).getName())) {
//                    groupList.get(i).addStudent(studentList.get(j));
//                }
//            }
//        }
    }

    public static void addGroupsToFaculty(List<Faculty> facultyList, List<Group> groupList) {
        for (int i = 0; i < facultyList.size(); i++) {
            for (int j = 0; j < groupList.size(); j++) {
                if (groupList.get(j).getFacultyName().equals(facultyList.get(i).getName())) {
                    facultyList.get(i).addGroup(groupList.get(j));
                }
            }
        }
    }

    public OptionalDouble getAverageMarkOfStudent(Student student) {
        List<Integer> studentsMarks = new ArrayList<>(student.getSubjects().values());
        return studentsMarks.stream().mapToInt(e -> e).average();
    }

    public OptionalDouble getAverageMarkInSubjectAndInGroupAndInFaculty(String faculty, String group, String subject) {
        return faculties.stream()
                .filter(f -> f.getName().equals(faculty))
                .flatMap(g -> g.getGroups().stream())
                .filter(g -> g.getName().equals(group))
                .flatMap(s -> s.getStudents().stream())
                .mapToDouble(s -> s.getSubjects().get(subject)).average();
    }

    public OptionalDouble getAverageMarkInSubjectForAllUniversity(String subject) {
        return faculties.stream()
                .flatMap(f -> {
                    try {
                        //if (faculties == null) throw new NullPointerException();
                        return f.getGroups().stream();
                    } catch (NullPointerException e) {
                        System.out.println(e);
                        return null;
                    }

                })
                .flatMap(g -> {
                    try {
                        return g.getStudents().stream();
                    } catch (NullPointerException e) {
                        System.out.println(e);
                        return null;
                    }

                })
                .mapToDouble(s -> {
                    try {
                        return s.getSubjects().get(subject);
                    } catch (NullPointerException e) {
                        System.out.println(e);
                        return 0;
                    }

                }).average();

    }


}
