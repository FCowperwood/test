package com.epam.automation.exceptions.medicaluniversity.exceptions;

public class NoStudentsException extends Exception {

    @Override
    public String toString() {
        return getClass() + "; " + "No students in the group";
    }
}
