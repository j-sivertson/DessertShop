package org.example;

import java.util.ArrayList;

public class Customer {

    //Attributes
    private String custName;
    private ArrayList<Order> orderHistory;
    private int custID;

    public static int nextCustID = 1000;

    //Constructors
    public Customer(String custName) {
        this.custName = custName;
        orderHistory = new ArrayList<>();
        custID = nextCustID;
        nextCustID++;
    }

    //Getters and Setters
    public String getCustName() {
        return custName;
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    public int getCustID() {
        return this.custID;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    //Methods
    public void addToHistory(Order order) {
        orderHistory.add(order);
    }
}
