package com.imit.tasks.third;

import java.util.Objects;

public class PackagedWeightProduct extends PackagedProduct {
    private final double weight;
    private final Product product;

    public PackagedWeightProduct(ProductPackaging productPackaging, double weight, Product product) {
        super(product.getName(), product.getDescription(), productPackaging);
        if (Double.compare(weight, 0.0) == -1) throw new IllegalArgumentException("Negative weight!");
        this.weight = weight;
        this.product = product;
    }

    public double getWeight() {
        return weight;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PackagedWeightProduct)) return false;
        PackagedWeightProduct that = (PackagedWeightProduct) o;
        return Double.compare(that.getWeight(), getWeight()) == 0 && Objects.equals(getProductPackaging(),
                that.getProductPackaging()) && Objects.equals(getProduct(), that.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductPackaging(), getWeight(), getProduct());
    }

    @Override
    public String toString() {
        return String.format("Весовой товар '%s' с упаковкой '%s' (%fкг)",
                product.getName(), productPackaging.getName(), weight);
    }

    public double getNetWeight() {
        return weight;
    }

    public double getGrossWeight() {
        return weight + productPackaging.getWeight();
    }
}
