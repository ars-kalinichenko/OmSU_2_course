package com.imit.tasks.third;

import java.util.Arrays;

public class ProductService {
    public static int countByFilter(ProductBatch batch, IFilter strFilter) {
        return (int) Arrays.stream(batch.getProducts()).
                filter(x -> strFilter.apply(x.getName())).count();
    }

    public static Boolean checkAllWeighted(ProductBatch batch) {
        return Arrays.stream(batch.getProducts()).
                allMatch(ProductService::checkProductType);
    }

    private static Boolean checkProductType(PackagedProduct product) {
        if (product instanceof PackagedProductSet) {
            PackagedProduct[] products = ((PackagedProductSet) product).getProducts();
            return Arrays.stream(products).
                    anyMatch(ProductService::checkProductType);
        }
        return product instanceof PackagedWeightProduct;
    }

    private static Boolean checkProductName(PackagedProduct product, IFilter strFilter) {
        if (product instanceof PackagedProductSet) {
            PackagedProduct[] products = ((PackagedProductSet) product).getProducts();
            return Arrays.stream(products).
                    anyMatch(x -> checkProductName(x, strFilter));
        }
        return strFilter.apply(product.getName());
    }

    public static int countByFilterDeep(ProductBatch batch, IFilter strFilter) {
        return (int) Arrays.stream(batch.getProducts()).
                filter(x -> checkProductName(x, strFilter)).count();
    }
}
