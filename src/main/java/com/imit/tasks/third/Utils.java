package com.imit.tasks.third;

import java.util.Arrays;

public class Utils {
    public static double getProductWeight(PackagedProduct... products) {
        return Arrays.stream(products).mapToDouble(PackagedProduct::getGrossWeight).sum();
    }
}
