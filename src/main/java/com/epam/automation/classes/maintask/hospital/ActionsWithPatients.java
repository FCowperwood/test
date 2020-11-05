package com.epam.automation.classes.maintask.hospital;

import java.util.List;
import java.util.stream.Collectors;

public class ActionsWithPatients {

    private List<Patient> patients;

    public ActionsWithPatients(List<Patient> patients) {
        this.patients = patients;

    }

    public List<Patient> getListOfPatiensWithThisDiagnosis(String diagnosis) {
        List<Patient> patientList = patients
                .stream()
                .filter(p -> p.getDiagnosis().contains(diagnosis))
                .collect(Collectors.toList());

        return patientList;
    }

    public List<Patient> getListOfPatiensWithIntervalMedicalCards(int fromThisNumber, int toThisNumber) {
        List<Patient> patientList = patients
                .stream()
                .filter(p -> p.getMedicalCardNumber() >= fromThisNumber)
                .filter(p -> p.getMedicalCardNumber() <= toThisNumber)
                .collect(Collectors.toList());

        return patientList;
    }
}
