package com.epam.automation.collections.maintask.chef.vegetables;

public class Onion extends Vegetable {

    private int contentK;

    public Onion() {
    }

    public Onion(String name, double proteinContent, double fatContent, double carbohydrateContent, int calorieContent, int vegetableWeight, int contentK) {
        super(name, proteinContent, fatContent, carbohydrateContent, calorieContent, vegetableWeight);
        this.contentK = contentK;
    }

    public int getContentK() {
        return contentK;
    }

    public void setContentK(int contentK) {
        this.contentK = contentK;
    }

    @Override
    public String toString() {
        return super.toString() +
                "potassium " + contentK + "mg";
    }
}
