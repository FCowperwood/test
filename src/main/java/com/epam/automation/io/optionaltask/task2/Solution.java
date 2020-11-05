package com.epam.automation.io.optionaltask.task2;

//2. Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private.

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        String path = "src/main/resources/io/optionaltask/task2/Solution.java";
        List<String> listSwappedValues = readLinesFromFile(path);

        for (int i = 0; i < listSwappedValues.size(); i++) {
            if (listSwappedValues.get(i).contains("public")) listSwappedValues.set(i, "private ");
        }
        writeReplacedValuesToFile(path, listSwappedValues);

    }

    public static List<String> readLinesFromFile (String path) {
        List<String> listSwappedValues = new ArrayList<>();
        String[] arraySwappedValues = null;
        String lineOfValues = null;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {

            while (true) {
                lineOfValues = bufferedReader.readLine();
                if (lineOfValues == null) break;
                arraySwappedValues = lineOfValues.split(" ");

                for (int i = 0; i < arraySwappedValues.length; i++) {
                    listSwappedValues.add(arraySwappedValues[i] + " ");
                }
                listSwappedValues.add("\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listSwappedValues;
    }

    public static void writeReplacedValuesToFile (String path, List<String> listSwappedValues) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            for (int i = 0; i < listSwappedValues.size(); i++) {
                bufferedWriter.write(listSwappedValues.get(i));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
