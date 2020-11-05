package com.epam.automation.classes.maintask.hospital;

import java.util.Objects;

public class Patient {
    private int id;
    private int medicalCardNumber;
    private String name;
    private String lastName;
    private String fathersName;
    private String address;
    private String phoneNumber;
    private String diagnosis;

    public static class Builder {
        private int id;
        private int medicalCardNumber;
        private String name;
        private String lastName;
        private String fathersName;
        private String address;
        private String phoneNumber;
        private String diagnosis;

        public Builder(int medicalCardNumber, String diagnosis) {
            this.medicalCardNumber = medicalCardNumber;
            this.diagnosis = diagnosis;
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder fathersName(String fathersName) {
            this.fathersName = fathersName;
            return this;
        }

        public Patient build() {
            return new Patient(this);
        }

    }

        private Patient(Builder builder) {
            id = builder.id;
            medicalCardNumber = builder.medicalCardNumber;
            name = builder.name;
            lastName = builder.lastName;
            fathersName = builder.fathersName;
            address = builder.address;
            phoneNumber = builder.phoneNumber;
            diagnosis = builder.diagnosis;

        }

    public void setId(int id) {
        this.id = id;
    }

    public void setMedicalCardNumber(int medicalCardNumber) {
        this.medicalCardNumber = medicalCardNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public int getId() {
        return id;
    }

    public int getMedicalCardNumber() {
        return medicalCardNumber;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", medicalCardNumber=" + medicalCardNumber +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fathersName='" + fathersName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id &&
                medicalCardNumber == patient.medicalCardNumber &&
                Objects.equals(name, patient.name) &&
                Objects.equals(lastName, patient.lastName) &&
                Objects.equals(fathersName, patient.fathersName) &&
                Objects.equals(address, patient.address) &&
                Objects.equals(phoneNumber, patient.phoneNumber) &&
                Objects.equals(diagnosis, patient.diagnosis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, medicalCardNumber, name, lastName, fathersName, address, phoneNumber, diagnosis);
    }
}
