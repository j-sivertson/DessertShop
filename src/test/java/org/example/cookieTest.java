package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class cookieTest {

    Cookie cookie = new Cookie("Chocolate Chip", 5, 12);

    @Test
    void testGetCookieQty() {
        assertEquals(5, cookie.getCookieQty());
    }

    @Test
    void testSetCookieQty() {
        cookie.setCookieQty(6);
        assertEquals(6, cookie.getCookieQty());
    }

    @Test
    void testGetPricePerDozen() {
        assertEquals(12, cookie.getPricePerDozen(),0.01);
    }

    @Test
    void testSetPricePerDozen() {
        cookie.setPricePerDozen(13.99);
        assertEquals(13.99, cookie.getPricePerDozen(), 0.01);
    }

    @Test
    void testGetPackaging() {
        assertEquals("Box" , cookie.getPackaging());
    }

    @Test
    void testSetPackaging() {
        cookie.setPackaging("Bag");
        assertEquals("Bag" , cookie.getPackaging());
    }

    @Test
    void testCalculateCost() {
        assertEquals(5,cookie.calculateCost(), 0.01);
    }

    @Test
    void testCalculateTax() {
        assertEquals(0.3625, cookie.calculateTax(), 0.0001);
    }

    @Test
    void testisSameAs() {
        Cookie cookie1 = new Cookie("Chocolate Chip", 6, 12);
        assertEquals(true, cookie.isSameAs(cookie1));
        Cookie cookie2 = new Cookie("Snicker Doodle", 5, 11);
        assertEquals(false, cookie.isSameAs(cookie2));
    }
}
