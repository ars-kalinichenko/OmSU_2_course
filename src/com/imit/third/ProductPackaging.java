package com.imit.third;

import java.util.Objects;

public class ProductPackaging {
    private final String name;
    private final double weight;

    public ProductPackaging(String name, double weight) {
        if (Double.compare(weight, 0.0) == -1) throw new IllegalArgumentException("Negative weight!");
        if (name == null) throw new IllegalArgumentException();
        this.name = name;
        this.weight = weight;
    }

    public ProductPackaging(ProductPackaging productPackaging) {
        this.name = productPackaging.getName();
        this.weight = productPackaging.getWeight();
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("Упаковка %s с весом %f", name, weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductPackaging)) return false;
        ProductPackaging that = (ProductPackaging) o;
        return Double.compare(that.getWeight(), getWeight()) == 0 && getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getWeight());
    }
}
