package com.imit.tasks.fourth;

import com.imit.tasks.third.Product;

import java.util.Arrays;

public class ComparatorDemo {
    public static void sortProducts(Product... products) {
        Arrays.sort(products, new ProductComparator());
    }
}
