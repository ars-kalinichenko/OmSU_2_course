package com.imit.tasks.third;

import static com.imit.tasks.third.Utils.getProductWeight;

public class PackagedPieceProductSet extends PackagedProduct {
    private final PackagedPieceProduct[] products;

    public PackagedPieceProductSet(String name, String description, ProductPackaging productPackaging, PackagedPieceProduct... products) {
        super(name, description, productPackaging);
        this.products = products;
    }


    public PackagedPieceProduct[] getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return String.format("Набор товаров в упаковке %s", productPackaging.getName());
    }


    public double getNetWeight() {
        return getProductWeight();
    }

    public double getGrossWeight() {
        return getProductWeight() + productPackaging.getWeight();
    }
}
