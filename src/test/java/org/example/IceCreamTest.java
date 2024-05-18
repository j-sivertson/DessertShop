package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class IceCreamTest {

    Icecream icecream = new Icecream("Chocolate", 2 ,6);

    @Test
    void testGetScoopCount() {
        assertEquals(2, icecream.getScoopCount());
    }

    @Test
    void testSetScoopCount() {
        icecream.setScoopCount(3);
        assertEquals(3, icecream.getScoopCount());
    }

    @Test
    void testGetPricePerScoop() {
        assertEquals(6, icecream.getPricePerScoop(),0.01);
    }

    @Test
    void testSetPricePerScoop() {
        icecream.setPricePerScoop(6.99);
        assertEquals(6.99, icecream.getPricePerScoop(),0.01);
    }

    @Test
    void testGetPackaging() {
        assertEquals("Bowl" , icecream.getPackaging());
    }

    @Test
    void testSetPackaging() {
        icecream.setPackaging("Bag");
        assertEquals("Bag" , icecream.getPackaging());
    }

    @Test
    void testCalculateCost() {
        assertEquals(12, icecream.calculateCost(), 0.01);
    }

    @Test
    void testCalculateTax() {
        assertEquals(0.87, icecream.calculateTax(), 0.01);
    }
}

