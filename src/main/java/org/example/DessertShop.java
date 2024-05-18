/**
 * File: DesertShop.java
 * Description: Print out a receipt dependent on the user input values.
 * Lessons Learned: I used how to create my own user interface and to implement it
 * Instructor's Name: Jeff Light
 *
 * @author: Josh Sivertson
 * @since: Feb. 15. 2024
 */

package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class DessertShop {

    static HashMap<String, Customer> customerDB = new HashMap<>();

    public static void main(String[] args) {

        boolean closed = false;
        while(!closed) {

            // Create a new instance of the Order class
            Order order = new Order();

            Scanner sIn = new Scanner(System.in);
            String choice;
            DessertItem orderItem;

            boolean done = false;
            while (!done) {
                System.out.println("\n1: Candy");
                System.out.println("2: Cookie");
                System.out.println("3: Ice Cream");
                System.out.println("4: Sunday");
                System.out.println("5: Admin Module");

                System.out.print("\nWhat would you like to add to the order? (1-5, Enter for done): ");
                choice = sIn.nextLine();

                if (choice.isEmpty()) {
                    done = true;
                } else {
                    switch (choice) {
                        case "1":
                            orderItem = userPromptCandy();
                            order.add(orderItem);
                            break;
                        case "2":
                            orderItem = userPromptCookie();
                            order.add(orderItem);
                            break;
                        case "3":
                            orderItem = userPromptIceCream();
                            order.add(orderItem);
                            break;
                        case "4":
                            orderItem = userPromptSundae();
                            order.add(orderItem);
                            break;
                        case "5":
                            userPromptAdmin();
                    }//end of switch (choice)
                }//end of if (choice.equals(""))
            }//end of while (!done)
            System.out.println("\n");

            //Add items to the order(hardcoded)
            order.add(new Candy("Candy Corn", 1.5, 0.25));
            order.add(new Candy("Gummy Bears", 0.25, 0.35));
            order.add(new Cookie("Chocolate Chip", 6, 3.99));
            order.add(new Icecream("Pistachio", 2, 0.79));
            order.add(new Sundae("Vanilla", 3, 0.69, "Hot Fudge", 1.29));
            order.add(new Cookie("Oatmeal Raisin", 2, 3.45));

            System.out.print("Enter the customer name: "); //Asking the customer for their name to store it later
            String customerName = sIn.nextLine();
            Customer customer = customerDB.get(customerName);
            if(customer == null){ //If the customer does not exist in the DB, add a new customer and add them to the DB
                customer = new Customer(customerName);
                customerDB.put(customerName, customer);
            }

            boolean valid = false; //Add payment type to order and then adds it to the customers orderHistory
            do {
                System.out.print("What form of payment will be used? (CASH,CARD,PHONE): "); //Ask for the customers payment method
                String answer = sIn.nextLine();
                for (Payable.PayType type : Payable.PayType.values()) {
                    if (answer.equalsIgnoreCase(type.name())) {
                        order.setPayType(type);
                        valid = true;
                    }
                }
                if(!valid) {
                    System.out.println("Invalid payment type. Please try again.\n");
                }

            } while (!valid);

            customer.addToHistory(order);

            //Print out the name, cost, and tax for every item
            //The following lines are commented out from week 5. Instead we are simply going to use the print statement to print everything in the correct format.
            //New format"
            Collections.sort(order.getOrderList());
            System.out.print(order.toString());
            String customerInfo = "\n-----------------------------------------------------------------------\n";
            customerInfo += String.format("Customer Name: %-13s Customer ID: %-13s Total Orders: %s", customer.getCustName(), customer.getCustID(), customer.getOrderHistory().size());
            System.out.print(customerInfo);

            // Print message to prompt the user to hit enter
            System.out.print("\n\nHit enter to start a new order");
            sIn.nextLine(); // Wait for the user to press Enter before proceeding

            //Old way:
//        for(DessertItem desert : order.getOrderList()) {
//            System.out.printf("%-25s$%-8.2f[Tax: $%.2f]\n", desert.getName(), desert.calculateCost(), desert.calculateTax());
//        }
//
//        System.out.println("----------------------------------------------");
//
//        System.out.printf("%-25s$%-8.2f[Tax: $%.2f]\n", "Subtotals:", order.orderCost(), order.orderTax());
//        System.out.printf("%-25s$%-8.2f\n", "Order Total:", order.orderCost() + order.orderTax());
//        System.out.println("Total item in your order " + order.itemCount());
        }
    }


    public static Cookie userPromptCookie() {
        Cookie cookie = new Cookie();

        Scanner iIn = new Scanner(System.in); //CREATING new integer scanner
        Scanner sIn = new Scanner(System.in); //CREATING new string scanner

        System.out.print("\nEnter the type of cookie: "); //Enter user input
        String cookieName = sIn.nextLine(); //Store cookie name
        cookie.setName(cookieName); //Add cookie name to the object variable

        boolean valid = false;
        do {
            System.out.print("Enter the quantity purchased: ");
            //try-catch validation for quantity purchased
            try {
                String cookieQtyInput = iIn.nextLine();
                int cookieQty = Integer.parseInt(cookieQtyInput);
                cookie.setCookieQty(cookieQty);
                valid = true;
            } catch (Exception e) {
                System.out.println("Please enter a whole number amount");
            }
        } while (!valid); //END of do while loop

        valid = false;

        do {
            System.out.print("Please enter the price per dozen: ");
            //do try catch for double validation
            try {
                String pricePerDozenInput = iIn.nextLine();
                double pricePerDozen = Double.parseDouble(pricePerDozenInput);
                cookie.setPricePerDozen(pricePerDozen);
                valid = true;
            } catch (Exception e) {
                System.out.println("Please enter a decimal number");
            }
        } while (!valid);

        return cookie;

    } //END of userPromptCookie method

    public static Candy userPromptCandy() {
        Candy candy = new Candy();

        Scanner iIn = new Scanner(System.in); //CREATING integer scanner
        Scanner sIn = new Scanner(System.in); //CREATING string scanner

        //Candy name
        System.out.print("\nPlease enter the type of candy: "); //ASK the user
        String candyType = sIn.nextLine(); //STORING input
        candy.setName(candyType); //ADDING the input to the class variable

        //Candy weight
        boolean valid = false;
        do {
            System.out.print("Please enter the candy weight: ");
            try {
                String candyWeightInput = iIn.nextLine();
                double candyWeight = Double.parseDouble(candyWeightInput);
                candy.setCandyWeight(candyWeight);
                valid = true;
            } catch (Exception e) {
                System.out.println("PLease enter a decimal number");
            }
        } while (!valid);

        valid = false;

        //Price Per Pound
        do {
            System.out.print("Please enter the prize per pound: ");
            try {
                String pricePerPoundInput = sIn.nextLine();
                double pricePerPound = Double.parseDouble(pricePerPoundInput);
                candy.setPricePerPound(pricePerPound);
                valid = true;
            } catch (Exception e){
                System.out.println("Please enter a decimal number");
            }
        } while (!valid);

        return candy;
    } //END of userPromptCandy Method

    public static Icecream userPromptIceCream() {
        Icecream icecream = new Icecream();

        Scanner sIn = new Scanner(System.in); //CREATING new string scanner
        Scanner iIn = new Scanner(System.in); //CREATING new integer scanner

        //Type of ice cream
        System.out.print("\nPlease enter the type of icecream: ");
        String icecreamType = sIn.nextLine();
        icecream.setName(icecreamType);

        //Scoop Count
        boolean valid = false;
        do {
            System.out.print("Please enter the number of scoops: ");
            try {
                String scoopCountInput = iIn.nextLine();
                int scoopCount = Integer.parseInt(scoopCountInput);
                icecream.setScoopCount(scoopCount);
                valid = true;
            } catch (Exception e) {
                System.out.println("Please enter a whole number");
            }
        } while(!valid); //END of do while loop

        valid = false;

        //Price per scoop
        do {
            System.out.print("PLease enter a price per scoop: ");
            try {
                String pricePerScoopInput = iIn.nextLine();
                double pricePerScoop = Double.parseDouble(pricePerScoopInput);
                icecream.setPricePerScoop(pricePerScoop);
                valid = true;
            } catch (Exception e) {
                System.out.println("PLease enter a decimal number");
            }
        } while (!valid);

        return icecream;

    } //END of userPromptIceCream method

    public static Icecream userPromptSundae() {
        Sundae sundae = new Sundae();

        Scanner sIn = new Scanner(System.in); //CREATING new string scanner
        Scanner iIn = new Scanner(System.in); //CREATING new integer scanner

        //Type of ice cream
        System.out.print("\nPlease enter the type of Sundae: ");
        String sundaeType = sIn.nextLine();
        sundae.setName(sundaeType);


        //Scoop Count
        boolean valid = false;
        do {
            System.out.print("Please enter the number of scoops: ");
            try {
                String scoopCountInput = iIn.nextLine();
                int scoopCount = Integer.parseInt(scoopCountInput);
                sundae.setScoopCount(scoopCount);
                valid = true;
            } catch (Exception e) {
                System.out.println("Please enter a whole number");
            }
        } while(!valid); //END of do while loop

        valid = false;

        //Price per scoop
        do {
            System.out.print("PLease enter a price per scoop: ");
            try {
                String pricePerScoopInput = iIn.nextLine();
                double pricePerScoop = Double.parseDouble(pricePerScoopInput);
                sundae.setPricePerScoop(pricePerScoop);
                valid = true;
            } catch (Exception e) {
                System.out.println("PLease enter a decimal number");
            }
        } while (!valid);

        valid = false;

        //Topping name
        System.out.print("Please enter the topping name: ");
        String toppingType = sIn.nextLine();
        sundae.setToppingName(toppingType);

        //Topping price
        do {
            System.out.print("PLease enter the topping price: ");
            try {
                String toppingPriceInput = sIn.nextLine();
                double toppingPrice = Double.parseDouble(toppingPriceInput);
                sundae.setToppingPrice(toppingPrice);
                valid = true;
            } catch (Exception e) {
                System.out.println("PLease enter a decimal number");
            }
        } while (!valid);

        return sundae;

    } //END of userPromptIceCream method

    public static void userPromptAdmin(){
        //Creating scanners
        Scanner sIn = new Scanner(System.in);
        Scanner nIn = new Scanner(System.in);


        String choice;
        boolean done = false;
        while(!done) {
            System.out.println("\n1: Shop Customer List");
            System.out.println("2: Customer Order History");
            System.out.println("3: Best Customer");
            System.out.println("4: Exit Admin Module");

            System.out.print("\nWhat would you like to do? (1-4): ");
            choice = sIn.nextLine();

            if (choice.isEmpty()) {
                done = true;
            } else {
                switch (choice) {
                    case "1":
                        System.out.println();
                        String custInfoHeader = String.format("%-40s%-15s", "Customer Name", "Customer ID");
                        System.out.print(custInfoHeader);
                        System.out.print("\n-----------------------------------------------------------------------\n");
                        customerDB.forEach((nameKey, customerValue) -> {
                            String custInfoLine = String.format("%-40s%-15s\n", nameKey, customerValue.getCustID());
                            System.out.print(custInfoLine);
                        });
                        break;
                    case "2":
                        System.out.print("Please enter the name of the customer: ");
                        String custName = sIn.nextLine();
                        System.out.println(); //This is just for formatting;

                        if(!customerDB.containsKey(custName)) {
                            System.out.printf("Sorry but the user %s does not exist in our database.\n", custName);
                        } else{
                            Customer foundCustomer = customerDB.get(custName);

                            String finalOutput = "";
                            finalOutput += String.format("Customer Name: %s Customer ID: %s", foundCustomer.getCustName(), foundCustomer.getCustID()); //Customer Info
                            finalOutput += "\n-----------------------------------------------------------------------\n";
                            for(Order order : foundCustomer.getOrderHistory()) {
                                finalOutput += String.format("Order #%s\n", foundCustomer.getOrderHistory().indexOf(order) + 1);
                                finalOutput +=String.format(order.toString());
                                finalOutput += "\n\n\n";
                            }
                            System.out.print(finalOutput);
                        }
                        break;
                    case "3":
                        double max = 0;
                        double custTotalOrderPrice = 0;
                        Customer bestCustomer = null;
                        for(Customer customer : customerDB.values()) {
                            custTotalOrderPrice = 0;
                            for(Order order : customer.getOrderHistory()) {
                                custTotalOrderPrice += order.orderCost() + order.orderTax();
                            }
                            if(custTotalOrderPrice > max) {
                                max = custTotalOrderPrice;
                                bestCustomer = customer;
                            }
                        }

                        String finalOutput = "\n-----------------------------------------------------------------------\n";
                        assert bestCustomer != null;
                        finalOutput += String.format("The Desert Shop's most valuable customer is: %s\nSpending a total of: $%.2f", bestCustomer.getCustName(), max);
                        finalOutput += "\n-----------------------------------------------------------------------\n";
                        System.out.print(finalOutput);
                        break;
                    case "4":
                        done = true;
                        break;
                }//end of switch (choice)
            }//end of if (choice.equals(""))
        }

    } //End of userPromptAdmin method
} //End of DessertShop Class
