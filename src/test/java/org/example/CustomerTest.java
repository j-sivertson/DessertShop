package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    Customer customer;
    @BeforeEach
    void setUp() {
        customer = new Customer("Josh");
    }

    @Test
    void getCustName() {
        assertEquals("Josh", customer.getCustName());
    }

    @Test
    void getOrderHistory() {
        assertTrue(customer.getOrderHistory().isEmpty());
    }

    @Test
    void getCustID() {
        assertEquals(1000, customer.getCustID());
    }

    @Test
    void setCustName() {
        customer.setCustName("Easton");
        assertEquals("Easton", customer.getCustName());
    }

    @Test
    void addToHistory() {
        Order order = new Order();
        customer.addToHistory(order);
        assertEquals(1, customer.getOrderHistory().size());
    }
}