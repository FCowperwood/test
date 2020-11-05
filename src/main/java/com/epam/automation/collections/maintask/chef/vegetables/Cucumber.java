package com.epam.automation.collections.maintask.chef.vegetables;

public class Cucumber extends Vegetable {

    private int contentSi;

    public Cucumber() {

    }

    public Cucumber(String name, double proteinContent, double fatContent, double carbohydrateContent, int calorieContent, int vegetableWeight, int contentSi) {
        super(name, proteinContent, fatContent, carbohydrateContent, calorieContent, vegetableWeight);
        this.contentSi = contentSi;
    }

    public int getContentSi() {
        return contentSi;
    }

    public void setContentSi(int contentSi) {
        this.contentSi = contentSi;
    }

    @Override
    public String toString() {
        return super.toString()+
                "silicium " + contentSi + "mg";
    }
}
