package com.epam.automation.exceptions.medicaluniversity.exceptions;

public class OutOfValueException extends Exception {

    private String mark;

    public OutOfValueException(String message, String mark) {
        super(message);
        this.mark = mark;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + " " + "current mark: " + mark + "; " + "mark must be greater than 0 and less than 10";
    }
}
