package com.epam.automation.exceptions.medicaluniversity.utility;

import com.epam.automation.exceptions.medicaluniversity.exceptions.NoSuchSubjectsException;
import com.epam.automation.exceptions.medicaluniversity.exceptions.OutOfValueException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadDataUtility {

    public  Map<String, Integer> readSubjectsAndMarksFromFile(String name, String lastName, String fathersName) {
        String fullName = (lastName + "-" + name + "-" + fathersName).toLowerCase();
        String filePath = "src/main/resources/exceptions/students/" + fullName + ".txt";
        //String filePath = String.valueOf(this.getClass().getResource());
        Map<String, Integer> subjectsAndMarks = new HashMap<>();
        String lineFromFile;
        String[] arrayValuesFromFile;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            if ((lineFromFile = bufferedReader.readLine()) == null) throw new NoSuchSubjectsException(fullName);

            do {
                arrayValuesFromFile = lineFromFile.split(":\\s");

                if (Integer.parseInt(arrayValuesFromFile[1]) > 10 || Integer.parseInt(arrayValuesFromFile[1]) < 0) {
                    throw new OutOfValueException(fullName, arrayValuesFromFile[1]);
                }

                subjectsAndMarks.put(arrayValuesFromFile[0], Integer.parseInt(arrayValuesFromFile[1]));

            } while ((lineFromFile = bufferedReader.readLine()) != null);

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchSubjectsException e) {
            e.printStackTrace();
        } catch (OutOfValueException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return subjectsAndMarks;
    }

}
