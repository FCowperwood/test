package com.epam.automation.collections.maintask.chef.vegetables;

import java.util.Objects;

public class Vegetable {

    private String name;
    private double proteinContent;
    private double fatContent;
    private double carbohydrateContent;
    private int calorieContent;
    private int vegetableWeight;

    public Vegetable() {
    }

    public Vegetable(String name, double proteinContent, double fatContent, double carbohydrateContent, int calorieContent, int vegetableWeight) {
        this.name = name;
        this.proteinContent = proteinContent;
        this.fatContent = fatContent;
        this.carbohydrateContent = carbohydrateContent;
        this.calorieContent = calorieContent;
        this.vegetableWeight = vegetableWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProteinContent() {
        return proteinContent;
    }

    public void setProteinContent(double proteinContent) {
        this.proteinContent = proteinContent;
    }

    public double getFatContent() {
        return fatContent;
    }

    public void setFatContent(double fatContent) {
        this.fatContent = fatContent;
    }

    public double getCarbohydrateContent() {
        return carbohydrateContent;
    }

    public void setCarbohydrateContent(double carbohydrateContent) {
        this.carbohydrateContent = carbohydrateContent;
    }

    public int getCalorieContent() {
        return calorieContent;
    }

    public void setCalorieContent(int calorieContent) {
        this.calorieContent = calorieContent;
    }

    public int getVegetableWeight() {
        return vegetableWeight;
    }

    public void setVegetableWeight(int vegetableWeight) {
        this.vegetableWeight = vegetableWeight;
    }

    @Override
    public String toString() {
        return name +
                " - protein " + proteinContent + "g" +
                ", fat " + fatContent + "g" +
                ", carbohydrate " + carbohydrateContent + "g" +
                ", calories " + calorieContent + "kk" +
                ", vegetable weight " + vegetableWeight + "g, ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vegetable vegetable = (Vegetable) o;
        return Double.compare(vegetable.proteinContent, proteinContent) == 0 &&
                Double.compare(vegetable.fatContent, fatContent) == 0 &&
                Double.compare(vegetable.carbohydrateContent, carbohydrateContent) == 0 &&
                calorieContent == vegetable.calorieContent &&
                vegetableWeight == vegetable.vegetableWeight &&
                Objects.equals(name, vegetable.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, proteinContent, fatContent, carbohydrateContent, calorieContent, vegetableWeight);
    }
}
