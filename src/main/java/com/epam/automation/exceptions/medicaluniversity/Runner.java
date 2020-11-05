package com.epam.automation.exceptions.medicaluniversity;

import com.epam.automation.exceptions.medicaluniversity.exceptions.NoSuchSubjectsException;
import com.epam.automation.exceptions.medicaluniversity.exceptions.OutOfValueException;
import com.epam.automation.exceptions.medicaluniversity.university.Faculty;
import com.epam.automation.exceptions.medicaluniversity.university.Group;
import com.epam.automation.exceptions.medicaluniversity.university.Student;
import com.epam.automation.exceptions.medicaluniversity.university.University;
import com.epam.automation.exceptions.medicaluniversity.utility.Utility;

import javax.swing.text.Utilities;
import java.io.*;
import java.util.*;

/*В университете есть несколько факультетов, в которых учатся студенты, объединенные в группы.
  У каждого студента есть несколько учебных предметов по которым он получает оценки.
  Необходимо реализовать иерархию студентов, групп и факультетов.

 - Посчитать средний балл по всем предметам студента
 - Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
 - Посчитать средний балл по предмету для всего университета

   Релизовать следующие исключения:
 - Оценка ниже 0 или выше 10
 - Отсутсвие предметов у студента (должен быть хотя бы один)
 - Отсутствие студентов в группе
 - Отсутствие групп на факультете
 - Отсутствие факультетов в университете*/

public class Runner {
    public static void main(String[] args) {
        Utility util = new Utility();

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(01, "Surgical", "S1", "Andrei", "Vasileuski", "Olegovich", "Nemiga 1-25", util.readSubjectsAndMarksFromFile("Andrei", "Vasileuski", "Olegovich")));
        studentList.add( new Student(02, "Therapy", "T1", "Petr", "Gaiduk", "Olegovich", "Nemiga 1-25", util.readSubjectsAndMarksFromFile("Petr", "Gaiduk", "Olegovich")));
        studentList.add(new Student(03, "Pediatric", "P2", "Elena", "Ostapenko", "Petrovna", "Nemiga 1-25", util.readSubjectsAndMarksFromFile("Elena", "Ostapenko", "Petrovna")));
        studentList.add(new Student(04, "Therapy", "T1", "Oleg", "Smirnov", "Leonidovich", "Nemiga 1-25", util.readSubjectsAndMarksFromFile("Oleg", "Smirnov", "Leonidovich")));
        studentList.add(new Student(05, "Therapy", "T1", "Svetlana", "Svirid", "Olegovna", "Nemiga 1-25", util.readSubjectsAndMarksFromFile("Svetlana", "Svirid", "Olegovna")));

        List<Group> groupList = new ArrayList<>();
        groupList.add(new Group("S1", "Surgical"));
        groupList.add(new Group("S2", "Surgical"));
        groupList.add(new Group("T1", "Therapy"));
        groupList.add(new Group("T2", "Therapy"));
        groupList.add(new Group("P1", "Pediatric"));
        groupList.add(new Group("P2", "Pediatric"));
        groupList.add(new Group("D1", "Dentistry"));
        groupList.add(new Group("D2", "Dentistry"));

        List<Faculty> facultyList = new ArrayList<>();
        facultyList.add(new Faculty("Surgical"));
        facultyList.add(new Faculty("Therapy"));
        facultyList.add(new Faculty("Pediatric"));
        facultyList.add(new Faculty("Dentistry"));

        University university = new University("Med-university", "Pavlov P.I", facultyList);

        university.addStudentsToGroup(groupList, studentList);
        university.addGroupsToFaculty(facultyList, groupList);



        // Посчитать средний балл по всем предметам студента.
        OptionalDouble averageMarkOfStudent = university.getAverageMarkOfStudent(studentList.get(0));
        System.out.println(studentList.get(0).getLastName() + " Средний балл = " + averageMarkOfStudent.getAsDouble() + "\n");

        // Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете.
        OptionalDouble averageMark = university.getAverageMarkInSubjectAndInGroupAndInFaculty("Therapy", "T1", "Anatomy");
        System.out.println(averageMark.isPresent() ? averageMark.getAsDouble() : null);

        // Посчитать средний балл по предмету для всего университета
        OptionalDouble averageMarkInAllUniversity = university.getAverageMarkInSubjectForAllUniversity("Neurology");
        System.out.println(averageMarkInAllUniversity.isPresent() ? averageMarkInAllUniversity.getAsDouble() : null);


    }

}
