package com.epam.automation.fundamentals.optionaltask1.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//2. Вывести числа в порядке возрастания (убывания) значений их длины.

public class Solution {

    public static void main(String[] args) {
        Map<String, Integer> enteredNumbers = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String enteredNumber;

            while (!(enteredNumber = bufferedReader.readLine()).isEmpty()) {
                enteredNumbers.put(enteredNumber, getQuantityCharactersOfEnteredNumber(enteredNumber));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        enteredNumbers.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                //.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))  //or in reverse order
                .forEach((i) -> System.out.println(i));

    }

    public static int getQuantityCharactersOfEnteredNumber(String passedValue) {
        char[] charactersOfPassedValue = passedValue.toCharArray();
        int lengthOfPassedValue = 0;

        for (int i = 0; i < charactersOfPassedValue.length; i++) {
            if (!(charactersOfPassedValue[i] == '-' || charactersOfPassedValue[i] == '.' || charactersOfPassedValue[i] == ',')) {
                lengthOfPassedValue++;
            }
        }
        return lengthOfPassedValue;
    }

}
