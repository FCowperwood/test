package com.epam.automation.fundamentals.optionaltask1.task7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//7. Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.

public class Solution {

    public static void main(String[] args) {

        List<String> mainListEnteredNumbers = new ArrayList<>();
        String allValuesOfNumberDifferent = null;
        boolean isEnteredValuePresent = true;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            while (isEnteredValuePresent) {
                String enteredNumber = bufferedReader.readLine();
                if (!enteredNumber.isEmpty()) {
                    mainListEnteredNumbers.add(enteredNumber);
                } else isEnteredValuePresent = false;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < mainListEnteredNumbers.size(); i++) {

            char[] charArray = mainListEnteredNumbers.get(i).toCharArray();
            List<Integer> listOfValuesEnteredNumber = new ArrayList<>();

            for (int j = 0; j < charArray.length; j++) {
                listOfValuesEnteredNumber.add(Character.getNumericValue(charArray[j]));
            }

            if (new Solution().isValuesOfNumberDifferent(listOfValuesEnteredNumber))
                allValuesOfNumberDifferent = mainListEnteredNumbers.get(i);
        }

        String result = allValuesOfNumberDifferent != null ? "Number is: " + allValuesOfNumberDifferent : "Number doesn't exist.";
        System.out.println(result);

    }

    public boolean isValuesOfNumberDifferent (List<Integer> list) {
        if (list.size() == 1 || (list.size() == 2 && list.get(0) == -1)) {
            return false;
        }

        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i) == list.get(j)) {
                    return false;
                }
            }
        }

        return true;
    }
}
