package com.epam.automation.collections.maintask.chef;

import com.epam.automation.collections.maintask.chef.vegetables.*;

import java.util.*;

public class Kitchen {

    public List<Vegetable> makeSalad() {
        String[] essentialIngredients = {"tomato.txt", "cucumber.txt", "bellpepper.txt", "onion.txt"};
        List<Vegetable> salad = new ArrayList<>();
        List<String> listValuesFromFile;
        
        for (int i = 0; i < essentialIngredients.length; i++) {
            String ingredient = essentialIngredients[i];
            listValuesFromFile = Runner.readValuesFromFile("src/main/resources/collections/chef/" + ingredient);

            salad.add(getNecessaryVegetable(ingredient, listValuesFromFile));
        }
        return salad;
    }

        public Vegetable getNecessaryVegetable(String ingredient, List<String> listValuesFromFile) {
            Vegetable vegetable;
            String name = listValuesFromFile.get(0);
            double protein = Double.parseDouble(listValuesFromFile.get(1));
            double fat = Double.parseDouble(listValuesFromFile.get(2));
            double carbohydrate = Double.parseDouble(listValuesFromFile.get(3));
            int calories = Integer.parseInt(listValuesFromFile.get(4));
            int weight = Integer.parseInt(listValuesFromFile.get(5));
            int personalVariable = Integer.parseInt(listValuesFromFile.get(6));

            switch (ingredient) {
                case ("tomato.txt"):
                    vegetable = new Tomato(name, protein, fat, carbohydrate, calories, weight, personalVariable);
                    break;
                case ("cucumber.txt"):
                    vegetable = new Cucumber(name, protein, fat, carbohydrate, calories, weight, personalVariable);
                    break;
                case ("bellpepper.txt"):
                    vegetable = new BellPepper(name, protein, fat, carbohydrate, calories, weight, personalVariable);
                    break;
                case ("onion.txt"):
                    vegetable = new Onion(name, protein, fat, carbohydrate, calories, weight, personalVariable);
                    break;
                default:
                    vegetable = null;
                    break;
            }
            return vegetable;
        }

    public int countCalories(List<Vegetable> salad) {
        int calorieCounter = 0;
        for (Vegetable vegetable : salad) {
            calorieCounter += (vegetable.getCalorieContent() * (vegetable.getVegetableWeight()/100d));
        }
        return calorieCounter;
    }

    public List<Vegetable> getVegetablesFromSaladWithCaloriesInterval(List<Vegetable> salad, int fromThisNumberCalories, int toThisNumberCalories) {
        List<Vegetable> vegetablesWithCaloriesInterval = new ArrayList<>();
        for (int i = 0; i < salad.size(); i++) {
            if (salad.get(i).getCalorieContent() >= fromThisNumberCalories && salad.get(i).getCalorieContent() <= toThisNumberCalories) {
                vegetablesWithCaloriesInterval.add(salad.get(i));
            }
        }
        return vegetablesWithCaloriesInterval;
    }

    public List<Vegetable> sortByProtein(List<Vegetable> salad) {
        List<Vegetable> sortedListOfVegetables = new ArrayList<>(salad);
        Collections.sort(sortedListOfVegetables, new Comparator<Vegetable>() {
            public int compare(Vegetable firstVegetable, Vegetable secondVegetable) {
                return Double.compare(firstVegetable.getProteinContent(), secondVegetable.getProteinContent());
            }
        });
        return sortedListOfVegetables;
    }

    public List<Vegetable> sortByFat(List<Vegetable> salad) {
        List<Vegetable> sortedListOfVegetables = new ArrayList<>(salad);
        Collections.sort(sortedListOfVegetables, new Comparator<Vegetable>() {
            public int compare(Vegetable firstVegetable, Vegetable secondVegetable) {
                return Double.compare(firstVegetable.getFatContent(), secondVegetable.getFatContent());
            }
        });
        return sortedListOfVegetables;
    }

    public List<Vegetable> sortByCarbohydrate(List<Vegetable> salad) {
        List<Vegetable> sortedListOfVegetables = new ArrayList<>(salad);
        sortedListOfVegetables.sort((Vegetable o1, Vegetable o2) -> (int)(o1.getCarbohydrateContent()-o2.getCarbohydrateContent()));
        return sortedListOfVegetables;
    }

    public List<Vegetable> sortByCalories(List<Vegetable> salad) {
        List<Vegetable> sortedListOfVegetables = new ArrayList<>(salad);
        Collections.sort(sortedListOfVegetables, new Comparator<Vegetable>() {
            public int compare(Vegetable firstVegetable, Vegetable secondVegetable) {
                return Double.compare(firstVegetable.getCalorieContent(), secondVegetable.getCalorieContent());
            }
        });
        return sortedListOfVegetables;
    }

}




