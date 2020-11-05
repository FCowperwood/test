package com.epam.automation.collections.maintask.chef.vegetables;

public class Tomato extends Vegetable {

    private int contentCo;

    public Tomato() {

    }

    public Tomato(String name, double proteinContent, double fatContent, double carbohydrateContent, int calorieContent, int vegetableWeight, int contentCo) {
        super(name, proteinContent, fatContent, carbohydrateContent, calorieContent, vegetableWeight);
        this.contentCo = contentCo;
    }

    public int getContentCo() {
        return contentCo;
    }

    public void setContentCo(int contentCo) {
        this.contentCo = contentCo;
    }

    @Override
    public String toString() {
        return super.toString() +
                "cobalt " + contentCo + "mkg";
    }
}
