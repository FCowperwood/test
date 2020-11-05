package com.epam.automation.fundamentals.optionaltask1.task7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//7. Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.

public class SecondSolution {

    public static void main(String[] args) {

        List<String> mainListEnteredNumbers = new ArrayList<>();
        String allValuesOfNumberDifferent = null;
        boolean isEnteredValuePresent = true;
        List<Integer> listOfConvertedNumber = new ArrayList<>();
        List<Integer> listOfValuesEnteredNumber = new ArrayList<>();

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
            listOfConvertedNumber.add(Integer.parseInt(mainListEnteredNumbers.get(i)));
            Integer numberFromList = listOfConvertedNumber.get(0);

            while (numberFromList != null) {
                if(numberFromList < 0) numberFromList = -numberFromList;

                listOfValuesEnteredNumber.add(numberFromList % 10);
                numberFromList = numberFromList / 10;

                if (numberFromList == 0) numberFromList = null;
            }

            Collections.reverse(listOfValuesEnteredNumber);

            if (listOfConvertedNumber.get(0) < 0) {
                listOfValuesEnteredNumber.set(0, -listOfValuesEnteredNumber.get(0));
            }

            if (isValuesOfNumberDifferent(listOfValuesEnteredNumber))
                allValuesOfNumberDifferent = mainListEnteredNumbers.get(i);
        }

        String result = allValuesOfNumberDifferent != null ? "Number is: " + allValuesOfNumberDifferent : "Number doesn't exist.";
        System.out.println(result);

    }

    public static boolean isValuesOfNumberDifferent (List<Integer> list) {
        if (list.size() == 1) {
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
