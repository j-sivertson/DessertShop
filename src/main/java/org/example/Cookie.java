package org.example;

import java.util.Scanner;

public class Cookie extends DessertItem implements SameItem<Cookie>{

    //Attributes
    private int cookieQty;
    private double pricePerDozen;

    //Constructors
    Cookie() {
        super();
        this.cookieQty = 0;
        this.pricePerDozen = 0.0;
        setPackaging("Box");
    }

    public Cookie(String name, int cookieQty, double pricePerDozen) {
        super(name);
        this.cookieQty = cookieQty;
        this.pricePerDozen = pricePerDozen;
        setPackaging("Box");
    }

    //Methods

    public int getCookieQty() {
        return cookieQty;
    }

    public double getPricePerDozen() {
        return pricePerDozen;
    }

    public void setCookieQty(int cookieQty) {
        this.cookieQty = cookieQty;
    }

    public void setPricePerDozen(double pricePerDozen) {
        this.pricePerDozen = pricePerDozen;
    }

    @Override
    public double calculateCost() {
        return this.cookieQty * (this.pricePerDozen/12.00);
    }

    @Override
    public String toString() {
        String line1 = String.format("%s Cookies (%s)", this.getName(), this.getPackaging());
        String line2Pt1 = String.format("%.2s lbs. @ $%.2f/dozen:", this.getCookieQty(), this.getPricePerDozen());
        String line2Pt2 = String.format("$%.2f", this.calculateCost());
        String line2Pt3 = String.format("[Tax: $%.2f]", this.calculateTax());
        String outputVar = String.format("%s\n\t%-45s%s%17s", line1, line2Pt1, line2Pt2, line2Pt3);

        return outputVar;
    }

    @Override
    public boolean isSameAs(Cookie other) {
        return this.pricePerDozen == other.pricePerDozen && this.getName().equalsIgnoreCase(other.getName());
    }
}
