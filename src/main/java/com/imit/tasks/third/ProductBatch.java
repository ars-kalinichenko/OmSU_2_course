package com.imit.tasks.third;

import java.util.Arrays;
import java.util.Objects;

public class ProductBatch {
    private final String description;
    private final PackagedProduct[] products;

    public ProductBatch(String description, PackagedProduct... products) {
        if (description == null) throw new IllegalArgumentException();
        this.description = description;
        this.products = products;
    }

    public String getDescription() {
        return description;
    }

    public PackagedProduct[] getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductBatch)) return false;
        ProductBatch that = (ProductBatch) o;
        return Objects.equals(getDescription(), that.getDescription()) && Arrays.equals(getProducts(), that.getProducts());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getDescription());
        result = 31 * result + Arrays.hashCode(getProducts());
        return result;
    }

    @Override
    public String toString() {
        return String.format("Партия товаров: %s %nТовары: %s", description, Arrays.toString(products));
    }

    public double getWeight() {
        return Utils.getProductWeight(products);
    }

}
