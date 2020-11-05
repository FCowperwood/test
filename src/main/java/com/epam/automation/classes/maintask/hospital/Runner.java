package com.epam.automation.classes.maintask.hospital;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

//Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
//Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти данные на консоль.
//В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.

//3. Patient: id, Фамилия, Имя, Отчество, Адрес, Телефон, Номер медицинской карты, Диагноз.
//Создать массив объектов. Вывести:
//a) список пациентов, имеющих данный диагноз;
//b) список пациентов, номер медицинской карты которых находится в заданном интервале.

public class Runner {

    static List<Patient> patients = Arrays.asList(
            new Patient.Builder(8050, "Myocardial infarction").id(1121).name("Oleg").lastName("Zaharov").fathersName("Arkadievich").address("Nemiga 1-26").phoneNumber("291113428").build(),
            new Patient.Builder(8051, "Bronchitis").id(1122).name("Oleg").lastName("Zaharov").fathersName("Arkadievich").address("Nemiga 1-26").phoneNumber("291113428").build(),
            new Patient.Builder(8052, "Pyelonephritis").id(1123).name("Oleg").lastName("Zaharov").fathersName("Arkadievich").address("Nemiga 1-26").phoneNumber("291113428").build(),
            new Patient.Builder(8053, "Bronchitis").id(1124).name("Oleg").lastName("Zaharov").fathersName("Arkadievich").address("Nemiga 1-26").phoneNumber("291113428").build(),
            new Patient.Builder(8054, "Arterial hypertension").id(1125).name("Alex").lastName("Zaharov").fathersName("Arkadievich").address("Nemiga 1-26").phoneNumber("291113428").build(),
            new Patient.Builder(8055, "Bronchitis").id(1123).name("Oleg").lastName("Zaharov").fathersName("Arkadievich").address("Nemiga 1-26").phoneNumber("291113428").build(),
            new Patient.Builder(8056, "Bilateral pneumonia").id(1127).name("Oleg").lastName("Zaharov").fathersName("Arkadievich").address("Nemiga 1-26").phoneNumber("291113428").build(),
            new Patient.Builder(8057, "Arterial hypertension").id(1128).name("Victor").lastName("Zaharov").fathersName("Arkadievich").address("Nemiga 1-26").phoneNumber("291113428").build(),
            new Patient.Builder(8058, "Asthma").id(1129).name("Oleg").lastName("Zaharov").fathersName("Arkadievich").address("Nemiga 1-26").phoneNumber("291113428").build(),
            new Patient.Builder(8059, "Arterial hypertension").id(1130).name("Oleg").lastName("Zaharov").fathersName("Arkadievich").address("Nemiga 1-26").phoneNumber("291113428").build(),
            new Patient.Builder(8060, "faint").build());

    public static void main(String[] args) {
        ActionsWithPatients actionsWithPatients = new ActionsWithPatients(patients);

        List<Patient> listOfPatiensWithTheDiagnosis = actionsWithPatients.getListOfPatiensWithThisDiagnosis("Arterial hypertension");
        for (Patient patient : listOfPatiensWithTheDiagnosis) {
            System.out.println(patient);
        }

        System.out.println();

        List<Patient> listOfPatiensWithIntervalMedicalCards = actionsWithPatients.getListOfPatiensWithIntervalMedicalCards(8052, 8054);
        for (Patient patient : listOfPatiensWithIntervalMedicalCards) {
            System.out.println(patient);
        }

    }
}
