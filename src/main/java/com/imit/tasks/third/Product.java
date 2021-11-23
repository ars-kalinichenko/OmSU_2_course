package com.imit.tasks.third;

import java.util.Objects;

public class Product {
    protected final String name;
    protected final String description;

    public Product(String name, String description) {

        if (name == null || description == null) throw new IllegalArgumentException();
        this.name = name;
        this.description = description;
    }

    public Product(Product product) {
        this.name = product.getName();
        this.description = product.getDescription();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getName(), product.getName()) && Objects.equals(getDescription(), product.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription());
    }

    public String getDescription() {
        return description;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Товар %s (%s)", name, description);
    }
}
