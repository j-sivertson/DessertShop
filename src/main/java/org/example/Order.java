package org.example;

import java.util.ArrayList;

public class Order implements Payable {
    private ArrayList<DessertItem> order;
    private PayType payMethod;

    // Default constructor
    public Order() {
        order = new ArrayList<DessertItem>();
        setPayType(PayType.CASH);
    }

    // Getter for order list
    public ArrayList<DessertItem> getOrderList() {
        return order;
    }

    // Method to add a DessertItem to the order
    public void add(DessertItem item) {
        if(item instanceof Candy) {
            for(DessertItem itemInOrder : order) {
                if(itemInOrder instanceof Candy && ((Candy)item).isSameAs((Candy)itemInOrder)){
                    ((Candy)itemInOrder).setCandyWeight( ((Candy)item).getCandyWeight() + ( (Candy) itemInOrder).getCandyWeight() );
                    return;
                }
            }
        }
        if(item instanceof Cookie) {
            for(DessertItem itemInOrder : order) {
                if(itemInOrder instanceof Cookie && ((Cookie)item).isSameAs((Cookie)itemInOrder)){
                    ((Cookie) itemInOrder).setCookieQty( ((Cookie) itemInOrder).getCookieQty() + ( (Cookie) item).getCookieQty() );
                    return;
                }
            }
        }
        order.add(item);
    }

    @Override
    public PayType getPayType() {
        return payMethod;
    }

    @Override
    public void setPayType(PayType payType){
        this.payMethod = payType;
    }

    // Method to get the item count in the order
    public int itemCount() {
        return order.size();
    }

    public double orderCost() {
        double orderCost = 0;
        for(DessertItem item : order) {
            orderCost += item.calculateCost();
        }
        return orderCost;
    }

    public double orderTax() {
        double taxTotal = 0;
        for(DessertItem desert : order) {
            taxTotal += desert.calculateTax();
        }
        return taxTotal;
    }
@Override
    public String toString() {
        String finalOutput = "";
        finalOutput += "----------------------------------Receipt------------------------------\n";
        for(DessertItem item : order) {
            finalOutput += item.toString() + "\n";
        }
        finalOutput += "-----------------------------------------------------------------------\n";
        String line1Pt1 = "Subtotals:";
        String line1Pt2 = String.format("$%.2f", this.orderCost());
        String line1Pt3 = String.format("[Tax: $%.2f]", this.orderTax());
        String line2Pt1 = "Order Total:";
        String lin2Pt2 = String.format("$%.2f", this.orderTax() + this.orderCost());
        String line3 = String.format("Total items in your order: %s", this.itemCount());
        finalOutput += String.format("%-49s%s%17s\n%-49s%s\n%s", line1Pt1, line1Pt2, line1Pt3, line2Pt1, lin2Pt2, line3);
        finalOutput += "\n-----------------------------------------------------------------------\n";
        finalOutput += String.format("Paid for with %s", this.payMethod);
        return finalOutput;
    }
}
