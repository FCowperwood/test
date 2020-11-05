package com.epam.automation.collections.maintask.chef.vegetables;

public class BellPepper extends Vegetable {

    private int contentVitC;

    public BellPepper() {
    }

    public BellPepper(String name, double proteinContent, double fatContent, double carbohydrateContent, int calorieContent, int vegetableWeight, int contentVitC) {
        super(name, proteinContent, fatContent, carbohydrateContent, calorieContent, vegetableWeight);
        this.contentVitC = contentVitC;
    }

    public int getContentVitC() {
        return contentVitC;
    }

    public void setContentVitC(int contentVitC) {
        this.contentVitC = contentVitC;
    }

    @Override
    public String toString() {
        return super.toString() +
                "vitC " + contentVitC + "mg";
    }
}
