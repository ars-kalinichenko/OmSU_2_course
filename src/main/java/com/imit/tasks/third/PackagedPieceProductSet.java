package com.imit.tasks.third;

import java.util.Arrays;

public class PackagedPieceProductSet {
    private final ProductPackaging productPackaging;
    private final PackagedPieceProduct[] products;

    public PackagedPieceProductSet(ProductPackaging productPackaging, PackagedPieceProduct... products) {
        this.productPackaging = productPackaging;
        this.products = products;
    }

    public ProductPackaging getProductPackaging() {
        return productPackaging;
    }

    public PackagedPieceProduct[] getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return String.format("Набор товаров в упаковке %s", productPackaging.getName());
    }

    private double getProductWeight() {
        return Arrays.stream(products).mapToDouble(PackagedPieceProduct::getGrossWeight).sum();
    }

    public double getNetWeight() {
        return getProductWeight();
    }

    public double getGrossWeight() {
        return getProductWeight() + productPackaging.getWeight();
    }
}
