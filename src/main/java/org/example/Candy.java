package org.example;
public class Candy extends DessertItem implements SameItem<Candy>{
    //Attributes
    private double candyWeight;
    private double pricePerPound;
    //Constructors
    Candy() {
        super();
        this.candyWeight = 0.0;
        this.pricePerPound = 0.0;
        setPackaging("Bag");
    }
    public Candy(String name, double candyWeight, double pricePerPound) {
        super(name);
        this.candyWeight = candyWeight;
        this.pricePerPound = pricePerPound;
        setPackaging("Bag");
    }
    //Methods

    public double getCandyWeight() {
        return candyWeight;
    }

    public double getPricePerPound() {
        return pricePerPound;
    }

    public void setCandyWeight(double candyWeight) {
        this.candyWeight = candyWeight;
    }

    public void setPricePerPound(double pricePerPound) {
        this.pricePerPound = pricePerPound;
    }

    @Override
    public double calculateCost(){
        return this.candyWeight * this.pricePerPound;
    }

    @Override
    public String toString() {
        String line1 = String.format("%s (%s)", this.getName(), this.getPackaging());
        String line2Pt1 = String.format("%.2f lbs. @ $%.2f/lb.:", this.getCandyWeight(), this.getPricePerPound());
        String line2Pt2 = String.format("$%.2f", this.calculateCost());
        String line2Pt3 = String.format("[Tax: $%.2f]", this.calculateTax());
        String outputVar = String.format("%s\n\t%-45s%s%17s", line1, line2Pt1, line2Pt2, line2Pt3);

        return outputVar;
    }

    @Override
    public boolean isSameAs(Candy other) {
        return this.getPricePerPound() == other.getPricePerPound() && this.getName().equalsIgnoreCase(other.getName());
    }
}
