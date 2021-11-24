package com.imit.tasks.third;

abstract public class PackagedProduct extends Product {
    protected final ProductPackaging productPackaging;

    public PackagedProduct(String name, String description, ProductPackaging productPackaging) {
        super(name, description);
        this.productPackaging = productPackaging;
    }

    public PackagedProduct(Product product, ProductPackaging productPackaging) {
        super(product);
        this.productPackaging = productPackaging;
    }


    public ProductPackaging getProductPackaging() {
        return productPackaging;
    }

    abstract public double getNetWeight();

    abstract public double getGrossWeight();
}
