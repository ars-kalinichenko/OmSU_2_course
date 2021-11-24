package com.imit.tasks.third;

import java.util.Objects;

public class PackagedPieceProduct extends PackagedProduct {
    private final int count;
    private final PieceProduct product;

    public PackagedPieceProduct(ProductPackaging productPackaging, int count, PieceProduct product) {
        super(product.getName(), product.getDescription(), productPackaging);
        if (count < 0) throw new IllegalArgumentException("Negative count!");
        this.count = count;
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PackagedPieceProduct)) return false;
        PackagedPieceProduct that = (PackagedPieceProduct) o;
        return getCount() == that.getCount() && Objects.equals(getProductPackaging(),
                that.getProductPackaging()) && Objects.equals(getProduct(), that.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductPackaging(), getCount(), getProduct());
    }

    @Override
    public String toString() {
        return String.format("Штучный товар '%s' с упаковкой '%s' (%d штук)",
                product.getName(), productPackaging.getName(), count);
    }

    public double getNetWeight() {
        return count * product.getWeight();
    }

    public double getGrossWeight() {
        return count * product.getWeight() + productPackaging.getWeight();
    }
}
