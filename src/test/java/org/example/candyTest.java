package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class candyTest {

    Candy candy = new Candy("KitKat", 10.2, 0.01);

    @Test
    void testGetCandyWeight() {
        assertEquals(10.2, candy.getCandyWeight(), 0.01);
    }

    @Test
    void testSetCandyWeight() {
        candy.setCandyWeight(11.3);
        assertEquals(11.3, candy.getCandyWeight(), 0.01);
    }

    @Test
    void testGetPricePerPound() {
        assertEquals(0.01, candy.getPricePerPound(),0.01);
    }

    @Test
    void testSetPricePerPound() {
        candy.setCandyWeight(0.02);
        assertEquals(0.02, candy.getCandyWeight(),0.01);
    }

    @Test
    void testGetPackaging() {
        assertEquals("Bag" , candy.getPackaging());
    }

    @Test
    void testSetPackaging() {
        candy.setPackaging("Box");
        assertEquals("Box" , candy.getPackaging());
    }

    @Test
    void testCalculateCost() {
        assertEquals(0.102, candy.calculateCost(), 0.001);
    }

    @Test
    void testCalculateTax() {
        assertEquals(0.007395, candy.calculateTax(), 0.000001);
    }

    @Test
    void isSameAsTest() {
        Candy candy1 = new Candy("KitKat", 10.2, 0.01);
        assertEquals(true, candy.isSameAs(candy1));
        Candy candy2 = new Candy("KitKat", 10.2, 0.02);
        assertEquals(false, candy.isSameAs(candy2));
    }

}
