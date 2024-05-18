package org.example;

public class Sundae extends Icecream {
    //Attributes
    private String toppingName;
    private double toppingPrice;
    //Constructors
    Sundae() {
        super();
        this.toppingName = "";
        this.toppingPrice = 0.0;
        setPackaging("Boat");
    }

    public Sundae(String name, int scoopCount, double pricePerScoop, String toppingName, double toppingPrice) {
        super(name, scoopCount,pricePerScoop);
        this.toppingName = toppingName;
        this.toppingPrice = toppingPrice;
        setPackaging("Boat");
    }
    //Methods

    public String getToppingName() {
        return toppingName;
    }

    public double getToppingPrice() {
        return toppingPrice;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public void setToppingPrice(double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    @Override
    public double calculateCost() {
        return (this.getScoopCount() * this.getPricePerScoop()) + this.toppingPrice;
    }

    @Override
    public String toString() {
        String line1 = String.format("%s %s Sundae (%s)", this.toppingName, this.getName(), this.getPackaging());
        String line2 = String.format("%s scoops of %s ice cream @ $%.2f/scoop", this.getScoopCount(), this.getName(), this.getPricePerScoop());
        String line3Pt1 = String.format("%s topping @ $%.2f:", this.getToppingName(), this.getToppingPrice());
        String line3Pt2 = String.format("$%.2f", this.calculateCost());
        String line3Pt3 = String.format("[Tax: $%.2f]", this.calculateTax());
        String outputVar = String.format("%s\n\t%s\n\t%-45s%s%17s", line1, line2, line3Pt1, line3Pt2, line3Pt3);

        return outputVar;
    }
}
