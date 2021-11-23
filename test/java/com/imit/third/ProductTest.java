package com.imit.third;

import org.testng.annotations.Test;

public class ProductTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public static void testConstructorNullName() {
        Product product = new Product(null, "description string");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public static void testConstructorNullDescription() {
        Product product = new Product("Name", null);
    }
}