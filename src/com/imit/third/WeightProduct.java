package com.imit.third;

public class WeightProduct extends Product {
    public WeightProduct(String name, String description) {
        super(name, description);
    }

    public WeightProduct(WeightProduct product) {
        super(product);
    }
}
