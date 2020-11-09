package com.epam.automation.exceptions.medicaluniversity.exceptions;

public class NoFacultiesException extends Exception {

    @Override
    public String toString() {
        return getClass() + "; " + "No faculties at the university";
    }
}
