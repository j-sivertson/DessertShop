package org.example;

import java.util.Scanner;

public abstract class DessertItem implements Packable, Comparable<DessertItem> {

    double taxPercentage = 7.25;
    //Attributes
    private String name;
    private String packable;
    //Constructors
    DessertItem() {
        name = "";
    }

    public DessertItem(String name) {
        this.name = name;
    }
    //Methods
    public double getTaxPercentage() {
            return this.taxPercentage;
    }

    public void setTaxPercentage(double taxPercentage) {
            this.taxPercentage = taxPercentage;
    }
    public abstract double calculateCost();

    public double calculateTax() {
        return this.calculateCost() * this.taxPercentage / 100;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPackaging() {
        return packable;
    }

    @Override
    public void setPackaging(String packable) {
        this.packable = packable;
    }

    @Override
    public int compareTo(DessertItem other) {
        return this.calculateCost() > other.calculateCost() ? 1 : this.calculateCost() < other.calculateCost() ? -1: 0;
    }
}
