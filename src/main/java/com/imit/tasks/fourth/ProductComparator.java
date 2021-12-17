package com.imit.tasks.fourth;

import com.imit.tasks.third.Product;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
    @Override
    public int compare(Product product, Product t1) {
        int i = product.getName().compareToIgnoreCase(t1.getName());
        if (i != 0) return i;
        return product.getDescription().compareToIgnoreCase(t1.getDescription());
    }
}
