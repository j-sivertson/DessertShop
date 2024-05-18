package org.example;

public class Icecream extends DessertItem {
    //Attributes
    private int scoopCount;
    private double pricePerScoop;
    //Constructors
    Icecream() {
        super();
        this.scoopCount = 0;
        this.pricePerScoop = 0.0;
        setPackaging("Bowl");
    }

    public Icecream(String name, int scoopCount, double pricePerScoop) {
        super(name);
        this.scoopCount = scoopCount;
        this.pricePerScoop = pricePerScoop;
        setPackaging("Bowl");
    }
    //Methods

    public int getScoopCount() {
        return scoopCount;
    }

    public double getPricePerScoop() {
        return pricePerScoop;
    }

    public void setScoopCount(int scoopCount) {
        this.scoopCount = scoopCount;
    }

    public void setPricePerScoop(double pricePerScoop) {
        this.pricePerScoop = pricePerScoop;
    }

    @Override
    public double calculateCost() {
        return this.scoopCount * pricePerScoop;
    }

    @Override
    public String toString() {
        String line1 = String.format("%s Ice Cream (%s)", this.getName(), this.getPackaging());
        String line2Pt1 = String.format("%.2s lbs. @ $%.2f/scoop:", this.getScoopCount(), this.getPricePerScoop());
        String line2Pt2 = String.format("$%.2f", this.calculateCost());
        String line2Pt3 = String.format("[Tax: $%.2f]", this.calculateTax());
        String outputVar = String.format("%s\n\t%-45s%s%17s", line1, line2Pt1, line2Pt2, line2Pt3);

        return outputVar;
    }
}
