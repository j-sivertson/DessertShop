package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DessertItemTest {
    Candy kitKat = new Candy("Kit Kat", 1.0, 1.0);
    Candy twix = new Candy("Twix", 2.0, 1.0);
    Candy skittles = new Candy("Skittles", 1.0, 1.0);

    @Test
    void testGetName() {
        assertEquals("Kit Kat", kitKat.getName());
    }

    @Test
    void testSetName() {
        kitKat.setName("Brownies");
        assertEquals("Brownies", kitKat.getName());
    }

    @Test
    void testGetTaxPercent() {
        kitKat.getTaxPercentage();
        assertEquals(7.25, kitKat.getTaxPercentage());
    }

    @Test
    void setTaxPercentage() {
        kitKat.setTaxPercentage(7.01);
        assertEquals(7.01, kitKat.getTaxPercentage(), 0.01);
    }

    @Test
    void testCompareToMethod() {
        assertEquals(-1, kitKat.compareTo(twix));
        assertEquals(1, twix.compareTo(kitKat));
        assertEquals(0, kitKat.compareTo(skittles));
    }


}