package com.epam.automation.exceptions.medicaluniversity.exceptions;

public class NoGroupsException extends Exception {

    @Override
    public String toString() {
        return getClass() + "; " + "No groups at the faculty";
    }
}
