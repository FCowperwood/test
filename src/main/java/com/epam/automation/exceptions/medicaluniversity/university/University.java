package com.epam.automation.exceptions.medicaluniversity.university;

import com.epam.automation.exceptions.medicaluniversity.exceptions.NoFacultiesException;
import com.epam.automation.exceptions.medicaluniversity.exceptions.NoGroupsException;
import com.epam.automation.exceptions.medicaluniversity.exceptions.NoStudentsException;

import java.util.*;
import java.util.stream.Stream;

public class University {

    private String name;
    private String rector;
    private List<Faculty> faculties;

    public University(String name, String rector, List<Faculty> faculties) {
        this.name = name;
        this.rector = rector;
        this.faculties = faculties;
    }

    public static void addStudentsToGroup(List<Group> groupList, List<Student> studentList) throws NoGroupsException, NoStudentsException {
        if (groupList == null) throw new NoGroupsException();
        for (int i = 0; i < groupList.size(); i++) {

            if (studentList == null) throw new NoStudentsException();
            for (int j = 0; j < studentList.size(); j++) {

                if (studentList.get(j).getGroup().equals(groupList.get(i).getName())) {
                    groupList.get(i).addStudent(studentList.get(j));
                }
            }
        }
    }

    public static void addGroupsToFaculty(List<Faculty> facultyList, List<Group> groupList) throws NoFacultiesException, NoGroupsException {
        if (facultyList == null) throw new NoFacultiesException();
        for (int i = 0; i < facultyList.size(); i++) {

            if (groupList == null) throw new NoGroupsException();
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

        try {

            if (faculties == null) throw new NoFacultiesException();

            if ((faculties.stream().flatMap(f -> f.getGroups().stream()).count()) == 0) throw new NoGroupsException();
            Stream<Group> groupStream = faculties.stream().filter(f -> f.getName().equals(faculty)).flatMap(f -> f.getGroups().stream());

            if (groupStream.flatMap(g -> g.getStudents().stream()).count() == 0) throw new NoStudentsException();
            groupStream = faculties.stream().filter(f -> f.getName().equals(faculty)).flatMap(f -> f.getGroups().stream());
            Stream<Student> studentStream = groupStream.filter(g -> g.getName().equals(group)).flatMap(g -> g.getStudents().stream());

            return studentStream.mapToDouble(s -> s.getSubjects().get(subject)).average();

        } catch (NoFacultiesException e) {
            e.printStackTrace();
        } catch (NoGroupsException e) {
            e.printStackTrace();
        } catch (NoStudentsException e) {
            e.printStackTrace();
        }

        return null;

    }

    public OptionalDouble getAverageMarkInSubjectForAllUniversity(String subject) {

        try {

            if (faculties == null) throw new NoFacultiesException();

            if ((faculties.stream().flatMap(f -> f.getGroups().stream()).count()) == 0) throw new NoGroupsException();
            Stream<Group> groupStream = faculties.stream().flatMap(f -> f.getGroups().stream());

            if (groupStream.flatMap(g -> g.getStudents().stream()).count() == 0) throw new NoStudentsException();
            groupStream = faculties.stream().flatMap(f -> f.getGroups().stream());
            Stream<Student> studentStream = groupStream.flatMap(g -> g.getStudents().stream());

            return studentStream.mapToDouble(s -> s.getSubjects().get(subject)).average();

        } catch (NoFacultiesException e) {
            e.printStackTrace();
        } catch (NoGroupsException e) {
            e.printStackTrace();
        } catch (NoStudentsException e) {
            e.printStackTrace();
        }

        return null;

    }



}
