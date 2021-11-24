package com.imit.tasks.third;

import java.util.Arrays;

public class ProductService {
    public static int countByFilter(ProductBatch batch, IFilter strFilter) {
        return (int) Arrays.stream(batch.getProducts()).
                filter(x -> strFilter.apply(x.getName())).count();
    }

    //    todo: add test
    public static Boolean checkAllWeighted(ProductBatch batch) {
        return Arrays.stream(batch.getProducts()).
                allMatch(x -> x instanceof PackagedWeightProduct);
    }

    private static Boolean checkProduct(PackagedProduct product, IFilter strFilter) {
        if (product instanceof PackagedPieceProductSet) {
            PackagedProduct[] products = ((PackagedPieceProductSet) product).getProducts();
            return Arrays.stream(products).
                    anyMatch(x -> strFilter.apply(x.getName()));
        }
        return strFilter.apply(product.getName());
    }

    //    todo: add test
    public static int countByFilterDeep(ProductBatch batch, IFilter strFilter) {
        return (int) Arrays.stream(batch.getProducts()).
                filter(x -> checkProduct(x, strFilter)).count();
    }
}
