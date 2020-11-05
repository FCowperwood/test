package com.epam.automation.io.optionaltask.task3;

import java.io.*;

//3. Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки.

public class Solution {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/com/epam/automation/io/optionaltask/task3/Solution.java"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/io/optionaltask/task3/solution-reverse.txt"))) {

            String lineOfValuesFromFile;
            boolean isLinePresent = true;
            char[] charArrayOfValuesFromFile;

            while(isLinePresent) {
                lineOfValuesFromFile = bufferedReader.readLine();

                if (!(lineOfValuesFromFile == null)) {
                    charArrayOfValuesFromFile = lineOfValuesFromFile.toCharArray();

                    for (int i = charArrayOfValuesFromFile.length-1; i >= 0; i--) {
                        bufferedWriter.write(charArrayOfValuesFromFile[i]);
                    }

                    bufferedWriter.write("\n");

                } else {
                    isLinePresent = false;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
