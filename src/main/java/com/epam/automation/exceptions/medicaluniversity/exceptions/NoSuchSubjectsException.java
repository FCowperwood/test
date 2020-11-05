package com.epam.automation.exceptions.medicaluniversity.exceptions;

public class NoSuchSubjectsException extends Exception {

    public NoSuchSubjectsException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return super.toString() + ";" + " " + "No subjects; must be at least one subject";
    }
}
