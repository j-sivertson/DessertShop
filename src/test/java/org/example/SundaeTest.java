package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class SundaeTest {
    Sundae sundae = new Sundae("Hot Fudge", 2, 6, "Oreo", 2);

    @Test
    void testToppingName() {
        assertEquals("Oreo", sundae.getToppingName());
    }

    @Test
    void testSetToppingName() {
        sundae.setToppingName("M&M");
        assertEquals("M&M", sundae.getToppingName());
    }

    @Test
    void testGetToppingPrice() {
        assertEquals(2, sundae.getToppingPrice(), 0.01);
    }

    @Test
    void testSetToppingPrice() {
        sundae.setToppingPrice(2.99);
        assertEquals(2.99, sundae.getToppingPrice(),0.01);
    }

    @Test
    void testGetPackaging() {
        assertEquals("Boat" , sundae.getPackaging());
    }

    @Test
    void testSetPackaging() {
        sundae.setPackaging("Bag");
        assertEquals("Bag" , sundae.getPackaging());
    }

    @Test
    void testCalculateCost() {
        assertEquals(14, sundae.calculateCost(), 0.01);
    }

    @Test
    void testCalculateTax() {
        assertEquals(1.015, sundae.calculateTax(), 0.001);
    }
}
